package com.lanou3g.giltsay.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/9/30.
 * 首页轮播图网络数据实体类
 */
public class HomeSelectRotateNetBean {

    /**
     * code : 200
     * data : {"banners":[{"ad_monitors":[],"channel":"all","id":730,"image_url":"http://img03.liwushuo.com/image/160929/68bib1c1a.jpg-w720","order":600,"status":0,"target_id":null,"target_url":"liwushuo:///page?type=dailylucky","type":"url","webp_url":"http://img03.liwushuo.com/image/160929/68bib1c1a.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":727,"image_url":"http://img02.liwushuo.com/image/160926/dv3mwtqob.jpg-w720","order":506,"status":0,"target":{"banner_image_url":"http://img02.liwushuo.com/image/160926/09m63zq84.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160926/09m63zq84.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img01.liwushuo.com/image/160926/8flri0x6f.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160926/8flri0x6f.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1474854917,"id":355,"posts_count":7,"status":1,"subtitle":"女神的礼物已经上线，等待开启！","title":"女神专属礼物","updated_at":1474855014},"target_id":355,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=topic&topic_id=355","type":"collection","webp_url":"http://img02.liwushuo.com/image/160926/dv3mwtqob.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":728,"image_url":"http://img01.liwushuo.com/image/160927/j2p31t3bp.jpg-w720","order":505,"status":0,"target_id":1045939,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=post&post_id=1045939","type":"post","webp_url":"http://img01.liwushuo.com/image/160927/j2p31t3bp.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":724,"image_url":"http://img03.liwushuo.com/image/160923/tjq6y9pyu.jpg-w720","order":500,"status":0,"target":{"banner_image_url":"http://img03.liwushuo.com/image/160923/pgzl0dojk.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160923/pgzl0dojk.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/160923/goy7dpn3y.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160923/goy7dpn3y.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1474629842,"id":354,"posts_count":12,"status":1,"subtitle":"十一长假：不在旅行中，就是在去旅行的路上。","title":" 长假打开方式","updated_at":1474630283},"target_id":354,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=topic&topic_id=354","type":"collection","webp_url":"http://img03.liwushuo.com/image/160923/tjq6y9pyu.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":726,"image_url":"http://img02.liwushuo.com/image/160923/iwedeg4nk.jpg-w720","order":479,"status":0,"target_id":1045899,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=post&post_id=1045899","type":"post","webp_url":"http://img02.liwushuo.com/image/160923/iwedeg4nk.jpg?imageView2/2/w/720/q/85/format/webp"}]}
     * message : OK
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * ad_monitors : []
         * channel : all
         * id : 730
         * image_url : http://img03.liwushuo.com/image/160929/68bib1c1a.jpg-w720
         * order : 600
         * status : 0
         * target_id : null
         * target_url : liwushuo:///page?type=dailylucky
         * type : url
         * webp_url : http://img03.liwushuo.com/image/160929/68bib1c1a.jpg?imageView2/2/w/720/q/85/format/webp
         */

        private List<BannersBean> banners;

        public List<BannersBean> getBanners() {
            return banners;
        }

        public void setBanners(List<BannersBean> banners) {
            this.banners = banners;
        }

        public static class BannersBean {
            private String channel;
            private int id;
            private String image_url;
            private int order;
            private int status;
            private Object target_id;
            private String target_url;
            private String type;
            private String webp_url;
            private List<?> ad_monitors;

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public Object getTarget_id() {
                return target_id;
            }

            public void setTarget_id(Object target_id) {
                this.target_id = target_id;
            }

            public String getTarget_url() {
                return target_url;
            }

            public void setTarget_url(String target_url) {
                this.target_url = target_url;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getWebp_url() {
                return webp_url;
            }

            public void setWebp_url(String webp_url) {
                this.webp_url = webp_url;
            }

            public List<?> getAd_monitors() {
                return ad_monitors;
            }

            public void setAd_monitors(List<?> ad_monitors) {
                this.ad_monitors = ad_monitors;
            }
        }
    }
}
