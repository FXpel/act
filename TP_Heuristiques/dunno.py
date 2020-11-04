import sys

def display_list(l) :
    for a in l :
        print(a)

def write_file(l):
	f = open("ordo.txt", "w")
	for a in l:
		f.write(str(a)+"\n")
	f.close()
def trifusion(T,comp) :
    if len(T)<=1 : return T
    T1=[T[x] for x in range(len(T)//2)]
    T2=[T[x] for x in range(len(T)//2,len(T))]
    return fusion(trifusion(T1,comp),trifusion(T2,comp),comp)

def fusion(T1,T2,comp) :
    if T1==[] :return T2
    if T2==[] :return T1
    if comp(T1[0],T2[0]) == 0 :
        return [T1[0]]+fusion(T1[1 :],T2,comp)
    else :
        return [T2[0]]+fusion(T1,T2[1 :],comp)

def tri_ins(t):
    for k in range(1,len(t)):
            temp=t[k]
            j=k
            while j>0 and temp<t[j-1]:
                t[j]=t[j-1]
                j-=1
            t[j]=temp
    return t

def comp_arrivee(a,b) :
    if a[0]<=b[0] : return 0
    if a[0]>b[0] : return 1
def comp_arrivee_sur_duree(a,b) :
    if a[0]/a[2]<=b[0]/b[2] : return 0
    else : return 1
def comp_arrivee_plus_duree(a,b) :
    if a[0]+a[2]< b[0]+b[2] : return 0
    else : return 1
def comp_arrivee_et_duree(a,b):
    if a[0]<= b[0] :
        if a[2] <= b[2]:
            return 0
    else : return 1
def comp_arrivee_et_duree_taille(a,b):
    if a[0]<= b[0] :
        if a[2] <= b[2]:
            if a[1] <= b[1]:
                pass
                return 0
    else : return 1
def comp_arrivee_plus_duree_et_size_inf(a,b):
    if a[0]+a[2]<= b[0]+b[2] :
        if a[1] <= b[1]:
            return 0
    else : return 1

def comp_arrivee_plus_duree_et_size_sup(a,b):
    if a[0]+a[2]<= b[0]+b[2] :
        if a[1] >= b[1]:
            return 0
    else : return 1
def comp_arrivee_size(a,b):
    if a[0]<=b[0] :
        if a[1]<= b[1]:
            return 0
    else :
        return 1
def comp_size(a,b) :
    if a[1]<=b[1] : return 0
    if a[1]>b[1] : return 1

def comp_duration(a,b) :
    if a[2]<b[2] : return 0
    else : return 1

def sortby(comp):
    mode = input("mode 0 : automatic test , mode 1 : innput test")
    if(mode == '1'):
        m = input("nombre de machines")
        n = input("nombre de taches")
        l = []
        for i in range(n):
            idx_i = i
            a_i = input("arrivee de la tache :")
            size_i = input("taille de la tache :")
            t_i = input("duree de la tache :")
            l += [(a_i,size_i,t_i,idx_i)]
    if(mode == '0'):
        m=100
        n=7
        l=test_list
    else :
        print("please choose between 0 or 1")
        sortby(comp)
        sys.exit()
    res = trifusion(l,comp)

    return res

def find_smallest_task(ltask):
	min = ltask[0]
	for x in ltask:
		if(x[0] + x[2] < min[0] + min[2]) :
			min = x

	return min
def sched2(ltask,nb_engine,nb_task,type_sort):
    l_sort = sortby(type_sort)
    l=[0] * nb_task
    task_executing=[]
    next_start = 0
    current_nb_engine = nb_engine
    for task in l_sort:
        if (task[1] <= current_nb_engine) :
            task_executing+= [task]
            current_nb_engine -= task[1]
            if(task[0] <= next_start):
                l[task[3]] = next_start
            else:
                l[task[3]] = task[0]
        else:
            while(current_nb_engine < task[1]):
                finished_task = find_smallest_task(task_executing)
                current_nb_engine += finished_task[1]
                if(finished_task[0] + finished_task[2]>= next_start):
                    next_start = l[ltask.index(finished_task)]+ finished_task[2]
                task_executing.remove(finished_task)
                if(finished_task[0] + finished_task[2]< next_start):
                    next_start += finished_task[2]
            if(task[0] > next_start) :
                next_start = task[0]
            current_nb_engine -= task[1]
            task_executing += [task]
            l[task[3]] = next_start



    return l;

def test(file):
	list=[]
	f=open(file,"r")
	f1 = f.readlines()
	m = int(f1[0])
	n = int(f1[1])
	for x in range(2,len(f1)):
		t = f1[x].split(' ')
		list += [(int(t[0]),int(t[1]),int(t[2]), x-2)]
	return list,m,n




res = test("donnees_test.txt")
test_list = res[0]

# taille = sortby(comp_size)
# display_list(taille)
m = res[1]
n = res[2]
print()
print("ordonnencement")
#taille = sortby(comp_size)
# display_list(taille)
print(n)
ordo = sched2(test_list,m,n,comp_arrivee_et_duree_taille)
display_list(ordo)
write_file(ordo)
# ordo_taille = sched2(test_list,m)
# print("ordonnencement")
# display_list(ordo_taille)

# taille = sortby(comp_size)
# duree = sortby(comp_duration)
