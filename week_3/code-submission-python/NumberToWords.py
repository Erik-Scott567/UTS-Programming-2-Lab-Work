single = [" ", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"]
doubles = ["","ten","twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"]
ten_power = ["hundred", "thousand"]

a = [1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000]
r = ["I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"]

def int_to_words(n):
    #Write your code here
    if num == 0:
        return "zero"
    
    word_result = []

    if num >= 1000:
        word_result.append(single[num // 1000] + " " + ten_power[1])
        num %= 1000

    if num >= 100:
        word_result.append(single[num // 100] + " " + ten_power[0])
        num %= 100

        if num != 0:
            word_result.append("and")

    if num >= 20:
        word_result.append(doubles[num // 10])
        num %= 10

    if num > 0:
        word_result.append(single[num])

    return ' '.join(word_result)

def int_to_roman(num):
    #Write your code here
    result = []

    while num > 0:
        count = -1
        for i in range(len(a)):
            if num >= a[i]:
                count = i
        x = num // a[count]

        for j in range(x):
            result.append(r[count])
            num -= a[count]

    return ''.join(result)

if __name__ == '__main__':
    #Write your code here 
    run = True
    while run:
        num = int(input("Number: "))
        if num == -1:
            run = False
        else: 
            roman_numerial = int_to_roman(num)
            written_num = int_to_words(num)
            print("In Words:", written_num)
            print("In Roman:", roman_numerial)

    print("Done")