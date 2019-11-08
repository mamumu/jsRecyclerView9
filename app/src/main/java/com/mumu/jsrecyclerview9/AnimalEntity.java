package com.mumu.jsrecyclerview9;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author : zlf
 * date    : 2019/11/7
 * github  : https://github.com/mamumu
 * blog    : https://www.jianshu.com/u/281e9668a5a6
 * desc    :
 */
public class AnimalEntity implements Serializable {


    /**
     * timestamp : 1572936963166
     * restbody : [{"type":1,"title1":"动物1","title2":"1","name1":"小狗1","name2":"小猫1"},{"type":2,"title1":"动物2","title2":"2","name1":"小狗2","name2":"小猫2"},{"type":3,"title1":"动物3","title2":"3","name1":"小狗3","name2":"小猫3"}]
     */

    private long timestamp;
    private List<RestbodyBean> restbody;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<RestbodyBean> getRestbody() {
        return restbody;
    }

    public void setRestbody(List<RestbodyBean> restbody) {
        this.restbody = restbody;
    }

    public static class RestbodyBean implements MultiItemEntity {
        /**
         * type : 1
         * title1 : 动物1
         * title2 : 1
         * name1 : 小狗1
         * name2 : 小猫1
         */

        private int type;
        private String title1;
        private String title2;
        private String name1;
        private String name2;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTitle1() {
            return title1;
        }

        public void setTitle1(String title1) {
            this.title1 = title1;
        }

        public String getTitle2() {
            return title2;
        }

        public void setTitle2(String title2) {
            this.title2 = title2;
        }

        public String getName1() {
            return name1;
        }

        public void setName1(String name1) {
            this.name1 = name1;
        }

        public String getName2() {
            return name2;
        }

        public void setName2(String name2) {
            this.name2 = name2;
        }

        @Override
        public int getItemType() {
            return type;
        }

        public RestbodyBean(int type, String title1, String title2, String name1, String name2) {
            this.type = type;
            this.title1 = title1;
            this.title2 = title2;
            this.name1 = name1;
            this.name2 = name2;
        }
    }
}
