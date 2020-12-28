def underSix(count) : #6개 미만 가격
    tot = cup * count
    if count == 5:
        tot += bag_4 + carrier * 3
    else if count == 4:
        tot += bag_4 + carrier * 2
    else if count == 3:
        tot += bag_2 + bag_1
    else if count == 2:
        tot += bag_2
    else if count == 1:
        tot += bag_1
    return tot



carrier = 95
bag_2 = 54
cup = 100
bag_4 = 80
bag_1 = 25

order_count = input()

total = order_count * cup

if order_count // 6 >= 1 :
    bag6Count = order_count // 6
    total += bag6Count * (bag_4 + carrier *3)
    
    total += underSix(order_count % 6)
else :
    total += underSix(order_count % 6) 
    
print("음료 포장값: %d", % total)
