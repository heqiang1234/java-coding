package com.leetcode.sginin;

import java.util.HashMap;

/**
 * @author: Mr.He
 * @create: 2022-05-27 10:07
 * @description: mst 17.11. 单词距离
 * <p>
 * 有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 * <p>
 * 示例：
 * <p>
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-closest-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question1711FindClosest {

    //想装呗，仿照hashmap写了一套，但是内存超了，失败
    static class ModeHash {
        int[] indexs;
        int size;
        final int extandSize = 2;

        public ModeHash() {
            indexs = new int[10];
            size = 0;
        }
        public ModeHash addIntSize(ModeHash modeHash){
            int newSize = extandSize * modeHash.indexs.length;
            int[] oldIndexs = modeHash.indexs;
            int [] newInt = new int[newSize];
            for (int i = 0; i < newSize; i++) {
                newInt[i] = oldIndexs[i];
            }
            ModeHash modeHash1 = new ModeHash();
            modeHash1.indexs = newInt;
            modeHash1.size = modeHash.size;
            return modeHash1;
        }
    }

    public static int findClosest(String[] words, String word1, String word2) {
        HashMap<String, ModeHash> map = new HashMap<>();
        int len = 0;
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            if (!str.equals("o") && !str.equals("fk") ){
                continue;
            }
            if (map.containsKey(str)) {
                ModeHash modeHash1 = map.get(str);
                int size = modeHash1.size;
                Boolean flag = false;
                ModeHash newModeHash = null;
                if (modeHash1.indexs.length > size * 0.75){
                   newModeHash = modeHash1.addIntSize(modeHash1);
                   flag = true;
                }
                if (flag){
                    map.replace(str,newModeHash);
                }
                map.get(str).indexs[size] = i;
                map.get(str).size++;
            } else {
                ModeHash modeHash = new ModeHash();
                modeHash.indexs[modeHash.size] = i;
                modeHash.size++;
                map.put(str, modeHash);
            }
        }
        ModeHash modeHashWord1 = map.get(word1);
        ModeHash modeHashWord2 = map.get(word2);

        return modLen(modeHashWord1,modeHashWord2);
    }

    public static int modLen(ModeHash word1,ModeHash word2){
        int [] wordNum1 = word1.indexs;
        int [] wordNum2 = word2.indexs;
        int word1Len = word1.size;
        int word2Len = word2.size;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < word1Len; i++) {
            for (int j = 0; j < word2Len; j++) {
                minLen = Math.min(Math.abs(wordNum1[i] - wordNum2[j]), minLen);
            }
        }
        return minLen;
    }

    public static int findClosest1(String[] words, String word1, String word2) {
        int index1 = -1,index2 = -1;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            if (str.equals(word1)) index1 = i;
            if (str.equals(word2)) index2 = i;

            if (index1 != -1 && index2 != -1){
                minLen = Math.min(minLen,Math.abs(index1 - index2));
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
       String [] words =  new String[]{"vg","ti","te","yd","ja","vqx","a","rtg","bn","rdg","v","sxz","t","gn",
               "bdc","bp","fk","nl","qr","qh","vo","d","ab","ui","gu","ft","kfr","a","jt","gyq","gmw","jqo","f",
               "iy","pu","kky","cur","qug","z","gb","osn","khg","szd","zhb","g","n","wbv","p","f","h","hka","j",
               "u","n","o","mod","hgc","bev","e","cx","jk","z","in","cua","on","nis","c","qpq","e","rs","ew","ms",
               "d","nh","h","cvu","oup","m","a","yb","v","t","rc","s","hfa","ehn","w","dox","ptt","r","jzm","l",
               "urm","qd","va","emi","sf","dc","h","wh","eh","z","c","mx","pm","bnn","fpk","sky","uyd","cwk","su",
               "xqc","xv","w","ai","dd","zic","qg","vmc","yrd","os","el","ylz","jac","b","mpw","nso","nzx","d","c",
               "nl","qo","vbe","p","lq","u","np","u","keo","gg","myh","emt","to","mfo","zlv","v","m","nm","i","lml",
               "v","wly","rd","bu","ymn","iu","br","r","gwz","nou","qod","ei","gt","ws","j","wgo","e","sn","rem","jmy",
               "hy","dm","qy","gmo","qz","xcm","iy","spz","yr","fc","cqo","pol","ib","u","ldd","fj","vj","v","hu","nr",
               "e","hf","fwv","eu","dd","o","zft","j","uz","j","ce","hwn","dcs","z","xyn","o","b","kx","kg","pjv","ooh",
               "k","r","fgj","wc","v","tjs","cq","aia","z","exs","be","py","zif","b","oy","o","aox","yf","i","tzn","ny",
               "xst","eo","soq","waz","cr","bf","l","yf","bj","p","eez","io","er","xe","w","iqh","as","wmx","pk","ge",
               "iet","xel","acc","yc","ek","bb","qip","igg","ejf","far","wkp","fzl","hhm","r","czh","vpw","z","jei",
               "tmi","m","zdw","obg","cq","ot","h","qj","m","nu","cbu","ffv","u","fc","vb","n","vr","myt","so","g",
               "pkl","gya","f","ahb","sn","ym","gk","i","nfn","e","efr","yu","xr","k","h","esf","uay","kws","czh",
               "fwr","no","trb","wo","ukc","p","dn","me","up","jde","fko","y","ghw","v","g","lnq","ztl","ppr","s",
               "o","wsj","z","rxc","o","b","gmv","kk","nak","i","gy","qv","yl","qn","lhs","r","n","ymy","d","ko",
               "y","nvm","sdu","dru","k","uk","yu","yg","dds","hoh","v","iv","tu","fe","k","d","ggz","d","yw","al",
               "vnu","b","u","f","up","krv","em","slq","cee","sbt","vl","t","tep","fz","db","q","z","m","x","l","ho",
               "bcm","fcy","x","l","ps","e","yld","rou","q","d","ldo","rjn","nb","a","zr","kle","nyz","xu","h","q","fxe",
               "aam","fho","kj","sw","i","jwa","joo","y","zrg","vdy","oc","o","cj","re","qw","wkk","s","of","nnj","or","p",
               "ih","ps","o","u","xsg","hi","w","bof","mvn","lgy","p","m","muq","avm","w","f","vl","ntu","b","b","hbz","iv",
               "qk","ttl","g","v","je","nej","e","s","hnu","pn","ygy","vos","ui","mvj","ae","sz","onr","mo","ar","ffs","oa",
               "v","qf","zi","ou","utq","fx","yb","u","t","jy","oh","jyv","tju","w","vl","qft","s","hlb","hyb","su","ol","hzr",
               "xd","j","kt","x","kzi","d","epx","gf","lxy","pmy","d","not","sbc","h","ial","rz","ypf","yd","p","hp","gck","d",
               "r","hlb","r","zl","jbr","uaw","wz","pjc","v","bs","gh","rqv","msp","f","oaf","zp","mrh","az","br","ro","oj","zfa",
               "ejr","gu","z","po","bc","p","we","yzw","qrg","j","wwv","bh","evz","m","h","m","mv","m","c","qz","b","vnx","hju","r",
               "sdu","qum","m","eq","doo","nbw","lvm","o","kfn","t","z","fpl","yqv","nf","h","gr","i","udm","j","v","sz","w","eef","vy","gow","ro","zmx","ts","dub","g","dvy","ye","gmr","b","b","y","y","hxn","dr","a","pmy","ick","fb","ny","hzb","x","nm","sqr","n","ial","xo","aw","egi","mrm","uh","i","unn","j","kg","tk","lar","o","iy","yh","ag","ss","jx","ory","p","k","o","c","vng","d","wa","ff","fks","v","cz","c","u","rxf","ccv","yx","n","rt","pzn","pih","b","goy","znl","iw","fym","sy","hq","dc","a","bbp","ql","oyx","afi","gry","of","gfg","lys","lz","ky","ssv","k","y","dj","woq","pw","wbz","e","x","o","b","ptl","n","lte","gv","cg","sx","v","q","qm","xs","dip","r","pyr","j","i","w","qot","by","sla","fum","e","jx","s","ws","ntq","xb","sq","t","ky","zzd","ykj","no","sy","zlc","v","cj","f","mzm","n","sh","ao","t","ky","rrh","s","wb","bsx","kko","jxv","j","iwd","vzo","kh","q","ulq","tba","er","oic","ca","qee","e","phs","ew","aj","hm","a","hm","o","nn","w","g","oi","di","urj","nn","dp","di","tu","lll","u","xya","o","e","rz","y","e","ybn","nkb","o","aj","dim","my","xdf","bcb","rf","rbr","b","ip","e","lw","oez","k","zx","hvj","tmh","cb","ghy","qju","hy","d","d","j","qu","zoq","r","z","l","bmz","tb","z","hsw","ctu","yd","wx","pka","b","xrl","ob","gp","e","r","vm","gt","qxo","c","fur","djn","vd","p","zq","xm","a","g","t","c","kh","uh","nsq","vjc","mys","v","q","o","vc","wee","rms","ah","se","fg","uo","fl","n","io","z","ww","e","m","o","kif","yqu","r","fqy","e","yuc","pvf","jni","ss","fi","wn","ct","lrd","dyt","j","kxs","oon","mw","mdk","ejj","m","uv","gid","ldu","ah","d","cxh","bb","lr","c","an","ey","g","sqs","z","zx","x","ejy","qi","c","q","p","nm","fn","v","z","rfz","sus","vh","nxy","oa","xdg","vc","l","fvb","i","z","igu","ay","t","xvp","n","xrl","v","e","cq","qv","or","ff","apj","za","hlx","p","y","tz","hng","d","j","ykt","ta","lp","lc","fhs","xp","gfl","tzi","v","x","tgo","jv","xoj","gux","eyx","adg","gjc","p","gw","hnl","p","jt","mlj","p","nv","trl","tp","dap","mc","lx","g","l","kjg","cax","jct","q","t","d","ww","vwd","zcl","yhr","fft","qq","y","wwz","sek","a","mc","vkq","m","yn","ope","kna","y","ve","w","z","mwm","a","i","d","ta","s","fs","pix","n","lio","xka","wbn","kag","v"};
        String word1 = "o", word2 = "fk";
        System.out.println(findClosest1(words, word1, word2));
    }
}
