package com.lanou3g.giltsay.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/9/17.
 * 首页轮播图实体类
 */
public class HomeSeRotateBean {
    private int imgId;
    private String imgUrl;
    /**
     * code : 200
     * data : {"banners":[{"ad_monitors":[],"channel":"all","id":730,"image_url":"http://img01.liwushuo.com/image/160929/68bib1c1a.jpg-w720","order":600,"status":0,"target_id":null,"target_url":"liwushuo:///page?type=dailylucky","type":"url","webp_url":"http://img01.liwushuo.com/image/160929/68bib1c1a.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":731,"image_url":"http://img01.liwushuo.com/image/160930/3seuzn0uv.jpg-w720","order":507,"status":0,"target":{"banner_image_url":"http://img03.liwushuo.com/image/160930/98g0egbsb.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160930/98g0egbsb.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img01.liwushuo.com/image/160930/1gljggdbc.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160930/1gljggdbc.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1475229970,"id":356,"posts_count":7,"status":1,"subtitle":"护肤达人的成长之路，海淘开启第一步","title":"海淘宝典","updated_at":1475230233},"target_id":356,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=topic&topic_id=356","type":"collection","webp_url":"http://img01.liwushuo.com/image/160930/3seuzn0uv.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":732,"image_url":"http://img03.liwushuo.com/image/161001/5bk3k6eo5.jpg-w720","order":0,"status":0,"target":{"banner_image_url":"http://img02.liwushuo.com/image/161001/jut2ofrw1.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/161001/jut2ofrw1.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/161001/py6yuemqe.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/161001/py6yuemqe.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1475327041,"id":357,"posts_count":7,"status":1,"subtitle":"初秋乱穿衣指南，回头率up，up！","title":"初秋换新装","updated_at":1475327214},"target_id":357,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=topic&topic_id=357","type":"collection","webp_url":"http://img03.liwushuo.com/image/161001/5bk3k6eo5.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"channel":"all","id":733,"image_url":"http://img01.liwushuo.com/image/161001/bvftzkor6.jpg-w720","order":0,"status":0,"target":{"banner_image_url":"http://img02.liwushuo.com/image/161001/d50iog9eh.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/161001/d50iog9eh.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img02.liwushuo.com/image/161001/vn25u2xq9.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/161001/vn25u2xq9.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1475327399,"id":358,"posts_count":7,"status":1,"subtitle":"这个秋季有Ta，让爱恒温相伴","title":"初秋保温杯来袭","updated_at":1475327565},"target_id":358,"target_type":"url","target_url":"liwushuo:///page?page_action=navigation&login=false&type=topic&topic_id=358","type":"collection","webp_url":"http://img01.liwushuo.com/image/161001/bvftzkor6.jpg?imageView2/2/w/720/q/85/format/webp"}]}
     * message : OK
     */

    private int code;
    private DataBean data;
    private String message;

    public HomeSeRotateBean(String image_url) {
        this.imgUrl = image_url;
    }

    public HomeSeRotateBean(int imgId, String imgUrl) {
        this.imgId = imgId;
        this.imgUrl = imgUrl;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

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
