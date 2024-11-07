public class graycodes {
    
}



/*  thoughts so far:
brgc (n) needs to generate the brgc of n (duh)
base case should print out [0, 1]
for n > 1, should print out bgrc (n-1) to get te brgc of n-1 (also duh)
then makes gray code by adding 0 to 1st half and 1 to 2nd half  of order n-1
main should init in a way that players should correspond to bits in the gray code 
should call bgrc(n)
should go through each gray code to get subset of current players and join/fade by checking code at n with n-1
print a nice formatted table (fun)
Bonus: change n from 5 players to 7, and adjust players arr

Pseudo:
BRGC(int n):
    if n ==1 :
    return ['0', '1']
    else: 
        L1 = BRGC(n-1)
        L2 = reversed(L1)
        res = []
        
        for code in L1:
            res.add('0' +  code)
        for code in l2:
            res.add('1' + code)
        
        return res

def main():
    n = 5 // n players
    players = ["Eduardo", "Darlene", "Clarice", "Barack", "Alexiev"] this should correspond to bits in gray code
    bonus change n to 7 and players add freddie and giselle to head of lizt

    graycodes = brgc(n)
    prev_code = null

    print('Index', 'code', 'players playing', 'action')
    for i in range(0, len(graycodes) - 1):
        code = graycodes[i]
        playersPlaying = []
        for j in range (0, n-1):
            if code[j] == 1:
            playersPlaying.add(players[j])

        if prev_code == null:
            action = 'silent'
        else:
            for k in range (0, n-1):
                if code[k] != precCode[k]:
                    if code[k] == '1':
                        action = players[k] + "joins"
                    else:
                        action = players[k] + 'fades'

                    break;
        playersplayingstr = join(playersplaying, & )
        print(i, code, playersplayingstr, action)
        prevcode = code
        end
        
*/