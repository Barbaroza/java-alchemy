package com.pmb.code.datastructure.stack;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Stack;

/**
 * @author lvrui
 */
public class SimplifyPath {
    String FILE_SEPERATE = File.separator;

    public String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length; i++) {
            if (!stack.isEmpty() && s[i].equals(".."))
                stack.pop();
            else if (!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."))
                stack.push(s[i]);
        }
        if (stack.isEmpty())
            return "/";

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            res.append("/" + stack.get(i));
        }
        return res.toString();
    }


    public String simplifyPath2(String path) {
        URL url = null;
        try {
            url = new URL(path);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url.toString();
    }


}
