package qiuguojun.bawei.com.ykmn.bean;

import java.util.List;

public class BBean {

   private  List<Result> result;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public class Result{
       private String imageUrl;

       public String getImageUrl() {
           return imageUrl;
       }

       public void setImageUrl(String imageUrl) {
           this.imageUrl = imageUrl;
       }
   }

}
