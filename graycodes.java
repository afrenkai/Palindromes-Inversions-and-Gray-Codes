import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class graycodes {
    public static List<String> brgc(int n) {
        if (n == 1) {
        List<String> res = new ArrayList<>();
        res.add("0");
        res.add("1");
        return res;
        }
        else {
            List<String> L1 = brgc(n-1);
            List<String> L2 = new ArrayList<>(L1);
            Collections.reverse(L2);
            List<String> res = new ArrayList<>();

            for (String code : L1) {
                res.add("0" + code);
            }
            for (String code : L2) {
                res.add("1" + code);
            }
            return res;
        }
    }

    // expects optional arg of n (number of players) and a comma separated list of names to add (might add contraints for lexicographical sorting). for example: 
    // java graycodes.java 2 Giselle,Freddie
    public static void main (String [] args) {
        int n;
        List<String> players = new ArrayList<>();
        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
            List<String> players_to_add = Arrays.asList(args[1].split("\\s*,\\s*"));
                for (int i = 0; i < players_to_add.size(); i++) {
                    players.add(players_to_add.get(i));
                }
            players.add("Eduardo");
            players.add("Darlene");
            players.add("Clarice");
            players.add("Barack");
            players.add("Alexiev");
        } else {
            n = 5;
            players.add("Eduardo");
            players.add("Darlene");
            players.add("Clarice");
            players.add("Barack");
            players.add("Alexiev");
        }
        List<String> graycodes = brgc(n);
        String lastcode = null;
        System.out.printf("%-5s %-10s %-20s %-10s%n", "Index", "Code", "Players Playing", "Action");
        for (int i = 0; i < graycodes.size(); i++) {
                String code = graycodes.get(i);
                List<String> playersPlaying = new ArrayList<>();
                String action = "silent";
        for (int j = 0; j < n; j++) {
            if (code.charAt(j) == '1') {
                playersPlaying.add(players.get(j));
            }
        }
        if (lastcode != null) {
            for (int k = 0; k < n; k++) {
                if (code.charAt(k) != lastcode.charAt(k)) {
                        if (code.charAt(k) == '1') {
                            action = players.get(k) + " joins";
                        } 
                        else {
                            action = players.get(k) + " fades";
                        }
                        break;
                    }
                }
            }
            String playersPlayingStr = String.join(" & ", playersPlaying);
            System.out.printf("%-5d %-10s %-20s %-10s%n", i, code, playersPlayingStr, action);
            lastcode = code;
        }
        
    }
}

    // public static String[] reverse(String [] arr) {
    //     for (int i = 0; i < arr.length/2; i++) {
    //         String temp = arr[i];
    //         arr[i] = arr[arr.length - i - 1];
    //         arr[arr.length - i - 1] = temp;
    //     }
    //     return arr;
    // }





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

Pseudo eerly similar to python, perhaps I have a disease:
def BRGC(int n):
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
    bonus change n to 7 and players add freddie and giselle to head of list

    graycodes = brgc(n)
    prev_code = null

    print('Index', 'code', 'players playing', 'action')
    for i in range(0, len(graycodes) - 1):
        code = graycodes[i]
        playersPlaying = []
        for j in range (0, n-1):
            if code[j] == 1:
            playersPlaying.add(players[j])

        if prev_code == None:
            action = 'silent'
        else:
            for k in range (0, n-1):
                if code[k] != prevCode[k]:
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