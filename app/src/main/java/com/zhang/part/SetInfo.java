package com.zhang.part;

import java.util.List;

/**
 * Created by zhang_shuai on 2017/9/25.
 * Del:
 */

public class SetInfo {

    /**
     * reason : success
     * result : {"bushou":"卜","head":"卧","pinyin":"wò xīn cháng dǎn","chengyujs":" 薪：柴草。睡觉睡在柴草上，吃饭睡觉都尝一尝苦胆。形容人刻苦自励，发奋图强。","from_":" 《史记·越王勾践世家》：\u201c越王勾践反国，乃苦身焦思，置胆于坐，坐卧即仰胆，饮食亦尝胆也。\u201d","example":" 中国足球要想冲出亚洲，必须～，刻苦训练。","yufa":" 联合式；作谓语、定语、状语；含褒义","ciyujs":"[stoop to conquer;firm resolve in danger to wipe out a national humiliation] 身卧于柴薪,口尝着苦胆。比喻发奋磨砺,时刻不忘雪耻","yinzhengjs":"春秋 时， 越王 勾践 战败，为 吴 所执，既放还，欲报 吴 仇，苦身焦思，置胆于坐，饮食尝之，欲以不忘 会稽 败辱之耻。见《史记·越王勾践世家》、 汉 赵晔 《吴越春秋·勾践归国外传》。卧薪事不知所出。后用为刻苦自励，发愤图强，不敢安逸之典。 宋 苏轼 《拟孙权答曹操书》：\u201c僕受遗以来，卧薪尝胆，悼日月之逾迈，而嘆功名之不立。\u201d《宋史·胡寅传》：\u201c太上皇劫制於强敌，生往死归，此臣子痛心切骨，卧薪尝胆，宜思所以为报也。\u201d 明 张凤翼 《灌园记·齐王拒谏》：\u201c他那里卧薪尝胆勤修政，我这里宴安鴆毒不思省，兵马临城待怎生？\u201d《胭脂血弹词》第七回：\u201c我则是，济河焚舟求雪耻，你须将，卧薪尝胆励君王。\u201d 李大钊 《国民之薪胆》：\u201c其外交黑幕之风云，以錮封於秘密之键，无从窥其奥藴，即此已足为吾民未来二十年卧薪尝胆之资。\u201d","tongyi":["发愤图强","宵衣旰食"],"fanyi":null}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * bushou : 卜
         * head : 卧
         * pinyin : wò xīn cháng dǎn
         * chengyujs :  薪：柴草。睡觉睡在柴草上，吃饭睡觉都尝一尝苦胆。形容人刻苦自励，发奋图强。
         * from_ :  《史记·越王勾践世家》：“越王勾践反国，乃苦身焦思，置胆于坐，坐卧即仰胆，饮食亦尝胆也。”
         * example :  中国足球要想冲出亚洲，必须～，刻苦训练。
         * yufa :  联合式；作谓语、定语、状语；含褒义
         * ciyujs : [stoop to conquer;firm resolve in danger to wipe out a national humiliation] 身卧于柴薪,口尝着苦胆。比喻发奋磨砺,时刻不忘雪耻
         * yinzhengjs : 春秋 时， 越王 勾践 战败，为 吴 所执，既放还，欲报 吴 仇，苦身焦思，置胆于坐，饮食尝之，欲以不忘 会稽 败辱之耻。见《史记·越王勾践世家》、 汉 赵晔 《吴越春秋·勾践归国外传》。卧薪事不知所出。后用为刻苦自励，发愤图强，不敢安逸之典。 宋 苏轼 《拟孙权答曹操书》：“僕受遗以来，卧薪尝胆，悼日月之逾迈，而嘆功名之不立。”《宋史·胡寅传》：“太上皇劫制於强敌，生往死归，此臣子痛心切骨，卧薪尝胆，宜思所以为报也。” 明 张凤翼 《灌园记·齐王拒谏》：“他那里卧薪尝胆勤修政，我这里宴安鴆毒不思省，兵马临城待怎生？”《胭脂血弹词》第七回：“我则是，济河焚舟求雪耻，你须将，卧薪尝胆励君王。” 李大钊 《国民之薪胆》：“其外交黑幕之风云，以錮封於秘密之键，无从窥其奥藴，即此已足为吾民未来二十年卧薪尝胆之资。”
         * tongyi : ["发愤图强","宵衣旰食"]
         * fanyi : null
         */

        private String bushou;
        private String head;
        private String pinyin;
        private String chengyujs;
        private String from_;
        private String example;
        private String yufa;
        private String ciyujs;
        private String yinzhengjs;
        private Object fanyi;
        private List<String> tongyi;

        public String getBushou() {
            return bushou;
        }

        public void setBushou(String bushou) {
            this.bushou = bushou;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getChengyujs() {
            return chengyujs;
        }

        public void setChengyujs(String chengyujs) {
            this.chengyujs = chengyujs;
        }

        public String getFrom_() {
            return from_;
        }

        public void setFrom_(String from_) {
            this.from_ = from_;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }

        public String getYufa() {
            return yufa;
        }

        public void setYufa(String yufa) {
            this.yufa = yufa;
        }

        public String getCiyujs() {
            return ciyujs;
        }

        public void setCiyujs(String ciyujs) {
            this.ciyujs = ciyujs;
        }

        public String getYinzhengjs() {
            return yinzhengjs;
        }

        public void setYinzhengjs(String yinzhengjs) {
            this.yinzhengjs = yinzhengjs;
        }

        public Object getFanyi() {
            return fanyi;
        }

        public void setFanyi(Object fanyi) {
            this.fanyi = fanyi;
        }

        public List<String> getTongyi() {
            return tongyi;
        }

        public void setTongyi(List<String> tongyi) {
            this.tongyi = tongyi;
        }
    }
}
