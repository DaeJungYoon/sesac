my_dict = {
    "name": "ken", 
    "age": 20, 
    "license": True
}

#get 메서드
# print(my_dict['adress'])
# print(my_dict.get('adress', 0))

# keys, values, items
print(my_dict.keys())
print(my_dict.values())
print(my_dict.items())

my_set = set()

# 원소 삽입
my_set.add(5)
print(my_set)

# 원소 삭제
# my_set.discard(5)
my_set.remove(5)
print(my_set)

# my_set.remove(3) # key err 발생
# my_set.discard(3) # key err 발생x