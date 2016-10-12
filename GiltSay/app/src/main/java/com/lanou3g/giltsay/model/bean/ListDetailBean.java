package com.lanou3g.giltsay.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/9/28.
 * 榜单详情页实体类
 */
public class ListDetailBean {


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
         * ad_monitors : null
         * brand_id : null
         * brand_order : null
         * category_id : 8
         * cover_image_url : http://img02.liwushuo.com/image/160728/o1qajfg4a_w.jpg-w720
         * cover_webp_url : http://img02.liwushuo.com/image/160728/o1qajfg4a_w.jpg?imageView2/2/w/720/q/85/format/webp
         * created_at : 1445851828
         * description : 设计优雅，低调奢华。粉色皮质钱包，手感超级柔软，送给她，诠释一个浪漫的七夕。
         * editor_id : 1023
         * favorites_count : 224
         * id : 1038678
         * image_urls : ["http://img01.liwushuo.com/image/160803/fioa7vge3.jpg-w720","http://img02.liwushuo.com/image/160803/55b40mr5z.jpg-w720","http://img02.liwushuo.com/image/160803/klm2m2h8l.jpg-w720","http://img02.liwushuo.com/image/160803/rfxgxe1mz.jpg-w720","http://img01.liwushuo.com/image/160728/o1qajfg4a_w.jpg-w720"]
         * keywords : undefined
         * name : CHARLES&KEITH·女式长款钱包
         * post_ids : []
         * price : 209.00
         * purchase_id : 37458323156
         * purchase_shop_id : null
         * purchase_status : 1
         * purchase_type : 2
         * purchase_url : http://s.click.taobao.com/t?e=m%3D2%26s%3DTonFvVAB6mwcQipKwQzePOeEDrYVVa64yK8Cckff7TVRAdhuF14FMdKy%2BkGoYVGfMMgx22UI05atgmtnxDX9deVMA5qBABUs5mPg1WiM1P5OS0OzHKBZzW1e2y4p13L5eI6sxEF%2BKSIStTDcMDoOve1Wmk9V%2B2PAxgxdTc00KD8%3D
         * subcategory_id : 58
         * updated_at : 1445851828
         * url : liwushuo:///page?type=item&page_action=navigation&item_id=1038678
         * webp_urls : ["http://img01.liwushuo.com/image/160803/fioa7vge3.jpg?imageView2/2/w/720/q/85/format/webp","http://img02.liwushuo.com/image/160803/55b40mr5z.jpg?imageView2/2/w/720/q/85/format/webp","http://img02.liwushuo.com/image/160803/klm2m2h8l.jpg?imageView2/2/w/720/q/85/format/webp","http://img02.liwushuo.com/image/160803/rfxgxe1mz.jpg?imageView2/2/w/720/q/85/format/webp","http://img01.liwushuo.com/image/160728/o1qajfg4a_w.jpg?imageView2/2/w/720/q/85/format/webp"]
         */

        private List<RecommendItemsBean> recommend_items;
        private List<?> recommend_posts;

        public List<RecommendItemsBean> getRecommend_items() {
            return recommend_items;
        }

        public void setRecommend_items(List<RecommendItemsBean> recommend_items) {
            this.recommend_items = recommend_items;
        }

        public List<?> getRecommend_posts() {
            return recommend_posts;
        }

        public void setRecommend_posts(List<?> recommend_posts) {
            this.recommend_posts = recommend_posts;
        }

        public static class RecommendItemsBean {
            private Object ad_monitors;
            private Object brand_id;
            private Object brand_order;
            private int category_id;
            private String cover_image_url;
            private String cover_webp_url;
            private int created_at;
            private String description;
            private int editor_id;
            private int favorites_count;
            private int id;
            private String keywords;
            private String name;
            private String price;
            private String purchase_id;
            private Object purchase_shop_id;
            private int purchase_status;
            private int purchase_type;
            private String purchase_url;
            private int subcategory_id;
            private int updated_at;
            private String url;
            private List<String> image_urls;
            private List<?> post_ids;
            private List<String> webp_urls;

            public Object getAd_monitors() {
                return ad_monitors;
            }

            public void setAd_monitors(Object ad_monitors) {
                this.ad_monitors = ad_monitors;
            }

            public Object getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(Object brand_id) {
                this.brand_id = brand_id;
            }

            public Object getBrand_order() {
                return brand_order;
            }

            public void setBrand_order(Object brand_order) {
                this.brand_order = brand_order;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public String getCover_image_url() {
                return cover_image_url;
            }

            public void setCover_image_url(String cover_image_url) {
                this.cover_image_url = cover_image_url;
            }

            public String getCover_webp_url() {
                return cover_webp_url;
            }

            public void setCover_webp_url(String cover_webp_url) {
                this.cover_webp_url = cover_webp_url;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getEditor_id() {
                return editor_id;
            }

            public void setEditor_id(int editor_id) {
                this.editor_id = editor_id;
            }

            public int getFavorites_count() {
                return favorites_count;
            }

            public void setFavorites_count(int favorites_count) {
                this.favorites_count = favorites_count;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getPurchase_id() {
                return purchase_id;
            }

            public void setPurchase_id(String purchase_id) {
                this.purchase_id = purchase_id;
            }

            public Object getPurchase_shop_id() {
                return purchase_shop_id;
            }

            public void setPurchase_shop_id(Object purchase_shop_id) {
                this.purchase_shop_id = purchase_shop_id;
            }

            public int getPurchase_status() {
                return purchase_status;
            }

            public void setPurchase_status(int purchase_status) {
                this.purchase_status = purchase_status;
            }

            public int getPurchase_type() {
                return purchase_type;
            }

            public void setPurchase_type(int purchase_type) {
                this.purchase_type = purchase_type;
            }

            public String getPurchase_url() {
                return purchase_url;
            }

            public void setPurchase_url(String purchase_url) {
                this.purchase_url = purchase_url;
            }

            public int getSubcategory_id() {
                return subcategory_id;
            }

            public void setSubcategory_id(int subcategory_id) {
                this.subcategory_id = subcategory_id;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public List<String> getImage_urls() {
                return image_urls;
            }

            public void setImage_urls(List<String> image_urls) {
                this.image_urls = image_urls;
            }

            public List<?> getPost_ids() {
                return post_ids;
            }

            public void setPost_ids(List<?> post_ids) {
                this.post_ids = post_ids;
            }

            public List<String> getWebp_urls() {
                return webp_urls;
            }

            public void setWebp_urls(List<String> webp_urls) {
                this.webp_urls = webp_urls;
            }
        }
    }
}
