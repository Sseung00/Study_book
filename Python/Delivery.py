def underSix(count) : #6개 미만 가격
    tot = 0
    if count == 5:
        tot += bag_4 + carrier * 3
    elif count == 4:
        tot += bag_4 + carrier * 2
    elif count == 3:
        tot += bag_2 + bag_1
    elif count == 2:
        tot += bag_2
    elif count == 1:
        tot += bag_1
    return tot



carrier = 95
bag_2 = 54
cup = 100
bag_4 = 80
bag_1 = 25

order_count = 5

total = order_count * cup
print("컵 %d원", % total)

if order_count // 6 >= 1 :
    bag6Count = order_count // 6
    total += bag6Count * (bag_4 + carrier *3)
    #print("대짜 쇼핑백 %d원, 캐리어 %d원", %(bag6Count * bag_4, bag6Count * carrier * 3))
    
    total += underSix(order_count % 6)
else :
    total += underSix(order_count % 6) 
    
print("총액: %d", %total)
