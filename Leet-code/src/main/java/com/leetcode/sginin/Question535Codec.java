package com.leetcode.sginin;

import java.util.HashMap;
import java.util.Random;

/**
 * @author HQ
 * @program: java-coding
 * @description: 535. TinyURL 的加密与解密
 * @date 2022-06-29 18:46:27
 * <p>
 * TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk 。请你设计一个类来加密与解密 TinyURL 。
 * <p>
 * 加密和解密算法如何设计和运作是没有限制的，你只需要保证一个 URL 可以被加密成一个 TinyURL ，并且这个 TinyURL 可以用解密方法恢复成原本的 URL 。
 * <p>
 * 实现 Solution 类：
 * <p>
 * Solution() 初始化 TinyURL 系统对象。
 * String encode(String longUrl) 返回 longUrl 对应的 TinyURL 。
 * String decode(String shortUrl) 返回 shortUrl 原本的 URL 。题目数据保证给定的 shortUrl 是由同一个系统对象加密的。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：url = "https://leetcode.com/problems/design-tinyurl"
 * 输出："https://leetcode.com/problems/design-tinyurl"
 * <p>
 * 解释：
 * Solution obj = new Solution();
 * string tiny = obj.encode(url); // 返回加密后得到的 TinyURL 。
 * string ans = obj.decode(tiny); // 返回解密后得到的原本的 URL 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/encode-and-decode-tinyurl
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question535Codec {

    HashMap<Integer, String> res = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int key = 0;
        Random random = new Random();
        while (res.containsKey(key)) {
            key = random.nextInt();
        }
        res.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = shortUrl.lastIndexOf('/') + 1;
        int temp = Integer.parseInt(shortUrl.substring(index));
        return res.get(temp);
    }

    public static void main(String[] args) {
        Question535Codec codec = new Question535Codec();
        codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl"));

    }
}
