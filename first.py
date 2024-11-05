my_lst = [3,5,1,2,4]
print(my_lst[-1])
print(my_lst[1:4]) #1<=x<4
print(my_lst[:]) #처음부터 끝까지
my_lst2 =my_lst[:] #복제
my_lst3 =my_lst[1:4:2] #1포함부터 4미만까지 두칸마다 슬라이싱
my_lst4 =my_lst[4:1:-1] #
my_lst4 =my_lst[::-1] #원본리스트를 뒤집는
my_lst5 =my_lst#복제가 아님
print(my_lst) #슬라이싱 원본데이터는 관여 X
