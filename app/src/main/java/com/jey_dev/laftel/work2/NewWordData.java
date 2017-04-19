package com.jey_dev.laftel.work2;

import java.util.ArrayList;

/**
 * Created by JeyHoon on 2017. 4. 19..
 */

public class NewWordData {
    private String startTag="";
    private String tagName="";
    private ArrayList<NewWordData> contents=new ArrayList<>();
    private String content="";

    public NewWordData(String content){
        setContents(content);
    }

    public String getResult(){
        String result="";
        if(contents.size()>0){
            for(int i=contents.size()-1; i>=0; i--){
                NewWordData data=contents.get(i);
                result=result+data.getResult();
            }
        }else{
            return reverseContent();
        }
        return putTag(result);
    }

    public void setContents(final String content){
        if (content.length()>0&&content.charAt(0) == '<') {
            setContent(content);
        }else{
            this.content=content;
        }
        ArrayList<String> strs=divStrings(this.content);
        if(strs.size()>1) {
            for (String str : strs) {
                if(str.length()>0)
                    contents.add(new NewWordData(str));

            }
        }else{

        }
    }
    public String toString(){
        return putTag(content);
    }
    public String putTag(String str){
        if(isTag())
            return "<"+startTag+">"+str+"</"+tagName+">";
        else return str;
    }
    public boolean isTag(){
        return null!=tagName&&tagName.length()>0;
    }
    public void setContent(String content) {
        if (content.charAt(0) == '<') {
            tagName = getFirstTag(content);
            startTag = content.substring(1, content.indexOf('>'));
        }
        if(tagName.equals("br")||tagName.equals("/br")){
            this.content="<"+tagName+">";
            tagName="";
            startTag="";
        }else
            this.content= getContent(content);
    }
    public String getContent(String tag,String substr){
        String startStr="<"+tag;
        String endStr="</"+tag;
        int end=substr.indexOf(endStr);
        String result=substr.substring(substr.indexOf('>',substr.indexOf(startStr))+1,end);
        return result;
    }
    public String getContent(String substr){
        if(null!=substr&&substr.contains("<")){
            if(substr.charAt(0)=='<'){
                String tag=getFirstTag(substr);
                return getContent(tag,substr);
            }
            else{
                String normalStr=substr.substring(0,substr.indexOf('<'));
                String tagStr=substr.substring(substr.indexOf('<'));
                return getContent(tagStr)+normalStr;//reverseString(normalStr);
            }
        }else{
            return substr;
        }
    }

    public String getFirstTag(String str){
        int start=str.indexOf('<');
        String tag="";
        for(int i=start+1; i<str.length(); i++){
            char ch=str.charAt(i);
            if(ch=='>'||ch==' ')
                break;
            tag=tag+String.valueOf(ch);
        }
        return tag;
    }
    private ArrayList<String> divStrings(String str){
        ArrayList<String> result=new ArrayList<>();
        if(str.equals("<br>")||str.equals("</br>")){
            result.add(str);
            return result;
        }
        String content="";
        for(int i=0; i<str.length();){
            char ch=str.charAt(i);
            if(ch=='<'){
                result.add(content);
                content="";
                String substr=str.substring(i);

                String tag=getFirstTag(substr);
                if(tag.equals("br")||tag.equals("/br")){
                    String c="<"+tag+">";
                    result.add(c);
                    i = c.length() + i;
                }else {

                    String endTag = "</" + tag + ">";
                    int end = substr.indexOf(endTag) + endTag.length();
                    i = end + i;
                    String subContent = substr.substring(0, end);
                    result.add(subContent);
                }


            }else{
                content=content+String.valueOf(ch);
                i++;
                if(i==str.length()&&content.length()>0){
                    result.add(content);
                }
            }

        }

        return result;
    }
    public String reverseString(String str){
        if(str.equals("<br>")||str.equals("</br>")){
            return str;
        }
        String result="";
        for(int i=str.length()-1; i>=0;i--){
            result=result+String.valueOf(str.charAt(i));
        }
        return result;
    }
    public String reverseContent(){
        if(isTag())
            return putTag(reverseString(content));
        else return reverseString(content);
    }
}
