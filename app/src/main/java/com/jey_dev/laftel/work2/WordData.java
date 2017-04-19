package com.jey_dev.laftel.work2;

import java.util.ArrayList;

/**
 * Created by JeyHoon on 2017. 4. 18..
 */

public class WordData {
    private String startTag="";
    private String tagName="";
    private ArrayList<WordData> contents=new ArrayList<WordData>();
    private String content="";
    private String startContent="";
    private String endContent="";
    private WordData sub=null;


//    public WordData (){
//
//    }
//    public WordData(String tagName, String content) {
//        this.tagName = tagName;
//        this.content=content;
//    }

    public WordData(String content) {
        setContents(content);
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public boolean isTag(){
        return null!=tagName&&tagName.length()>0;
    }

    public String getContent() {
        return content;
    }

    public String reverseContent(){
        if(isTag())
            return putTag(reverseString(content));
        else return reverseString(content);
    }

    public String getResult(){
        if(null!=sub){
            return putTag(reverseString(endContent)+sub.getResult()+reverseString(startContent));
        }else{
            return reverseContent();
        }
    }
    public String putTag(String str){
        if(isTag())
            return "<"+startTag+">"+str+"</"+tagName+">";
        else return str;
    }

    public void setContents(final String content){
        ArrayList<String> strs=divStrings(content);
        if(strs.size()==1){
            this.content=strs.get(0);
        }
        for(int i=0; i<strs.size(); i++){
            final String str=strs.get(i);
            contents.add(new WordData(str));
        }
    }

    public void setContent(String content) {
        ArrayList<String> strs=divStrings(content);
        if(content.charAt(0)=='<'){
            tagName=getFirstTag(content);
            startTag=content.substring(1,content.indexOf('>'));
        }
        String subContent=getContent(content);
        if(existTag(subContent)){
            this.startContent=subContent.substring(0,subContent.indexOf('<'));
            this.endContent=subContent.substring(subContent.lastIndexOf('>')+1);
            sub=new WordData(subContent.substring(subContent.indexOf('<'),subContent.lastIndexOf('>')+1));
        }else {
//            contents.add(subContent);
            this.content = subContent;
        }

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
    public String getContent(String tag,String substr){
        String startStr="<"+tag;
        String endStr="</"+tag;
        int end=substr.indexOf(endStr);
        String result=substr.substring(substr.indexOf('>',substr.indexOf(startStr))+1,end);
        return result;
    }
    public String reverseString(String str){
        String result="";
        for(int i=str.length()-1; i>=0;i--){
            result=result+String.valueOf(str.charAt(i));
        }
        return result;
    }

    public String toString(){
        return putTag(content);
    }
    private boolean existTag(String str){
        return str.contains("<");
    }

    private ArrayList<String> divStrings(String str){
        ArrayList<String> result=new ArrayList<>();

        String content="";
        for(int i=0; i<str.length();){
            char ch=str.charAt(i);
            if(ch=='<'){
                result.add(content);
                content="";
                String substr=str.substring(i);

                String tag=getFirstTag(substr);

                String endTag="</"+tag+">";
                int end=substr.indexOf(endTag)+endTag.length();
                i=end+i;
                String subContent=substr.substring(0,end);
                result.add(subContent);


            }else{
                content=content+String.valueOf(ch);
                i++;
                if(i==str.length()){
                    result.add(content);
                }
            }

        }

        return result;
    }

//    private String getReverseContentStr(){
//        String result="";
//        for(int i=contents.size()-1;i>=0;i--){
//            result=result+contents.get(i).getResult();
//        }
//        return result;
//    }
//    private String getContentStr(){
//        String result="";
//        for(int i=contents.size()-1;i>=0;i--){
//            result=resultcontents.get(i);
//        }
//    }


}
