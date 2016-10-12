package com.lanou3g.giltsay.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/10/8.
 * 轮播图详情实体类
 */
public class RotateDetailBean {

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
        private String banner_image_url;
        private String banner_webp_url;
        private String cover_image_url;
        private String cover_webp_url;
        private int created_at;
        private int id;
        /**
         * next_url : http://api.liwushuo.com/v2/collections/356/posts?generation=2&gender=1&limit=20&offset=20
         */

        private PagingBean paging;
        private int posts_count;
        private int status;
        private String subtitle;
        private String title;
        private int updated_at;
        private String url;
        /**
         * ad_monitors : []
         * author : {"avatar_url":"http://img03.liwushuo.com/image/160615/opsnztoj4.jpg","avatar_webp_url":null,"created_at":1465977637,"id":20,"nickname":"淘局长"}
         * column : {"banner_image_url":"http://img01.liwushuo.com/image/160608/rcmok6bpq.jpg-w300","category":"海淘","cover_image_url":"http://img03.liwushuo.com/image/160713/5cbekga4c.jpg-w720","created_at":1462500836,"description":"你想要的全世界，我都有！","id":3,"order":0,"post_published_at":1475053200,"status":0,"subtitle":"","title":"海淘情报局","updated_at":1475136047}
         * content_type : 1
         * content_url : http://www.liwushuo.com/posts/1044544/content
         * cover_image_url : http://img02.liwushuo.com/image/160720/nksfqgrph.jpg-w720
         * cover_webp_url : http://img02.liwushuo.com/image/160720/nksfqgrph.jpg?imageView2/2/w/720/q/85/format/webp
         * created_at : 1470042000
         * editor_id : 1023
         * feature_list : []
         * id : 1044544
         * introduction : 托韩剧和日剧的福，爱追剧的粉丝们也多少都被安利了不少零食，看到偶像们手里拿的小零食，吃货的第一个反应是看起来好像很好吃欸？求名字！有卖的没？真是个尽职的吃货~这次小礼君又来安利一些日本韩国零食，性价比超高，百元以内能买到清单上一大半好吃的。有没有吃过的小伙伴快来评论区告诉大家哇~
         * label_ids : []
         * liked : false
         * likes_count : 22654
         * limit_end_at : null
         * published_at : 1470042000
         * share_msg : 托韩剧和日剧的福，爱追剧的粉丝们也多少都被安利了不少零食，看到偶像们手里拿的小零食，吃货的第一个反应是看起来好像很好吃欸？求名字！有卖的没？真是个尽职的吃货~这次小礼君又来安利一些日本韩国零食，性价比超高，百元以内能买到清单上一大半好吃的。有没有吃过的小伙伴快来评论区告诉大家哇~
         * short_title : 日韩零食
         * status : 0
         * template :
         * title : 第61期 | 听说日韩剧里的他们，爱吃这些
         * type : post
         * updated_at : 1469790715
         * url : http://www.liwushuo.com/posts/1044544
         */

        private List<PostsBean> posts;

        public String getBanner_image_url() {
            return banner_image_url;
        }

        public void setBanner_image_url(String banner_image_url) {
            this.banner_image_url = banner_image_url;
        }

        public String getBanner_webp_url() {
            return banner_webp_url;
        }

        public void setBanner_webp_url(String banner_webp_url) {
            this.banner_webp_url = banner_webp_url;
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public int getPosts_count() {
            return posts_count;
        }

        public void setPosts_count(int posts_count) {
            this.posts_count = posts_count;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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

        public List<PostsBean> getPosts() {
            return posts;
        }

        public void setPosts(List<PostsBean> posts) {
            this.posts = posts;
        }

        public static class PagingBean {
            private String next_url;

            public String getNext_url() {
                return next_url;
            }

            public void setNext_url(String next_url) {
                this.next_url = next_url;
            }
        }

        public static class PostsBean {
            /**
             * avatar_url : http://img03.liwushuo.com/image/160615/opsnztoj4.jpg
             * avatar_webp_url : null
             * created_at : 1465977637
             * id : 20
             * nickname : 淘局长
             */

            private AuthorBean author;
            /**
             * banner_image_url : http://img01.liwushuo.com/image/160608/rcmok6bpq.jpg-w300
             * category : 海淘
             * cover_image_url : http://img03.liwushuo.com/image/160713/5cbekga4c.jpg-w720
             * created_at : 1462500836
             * description : 你想要的全世界，我都有！
             * id : 3
             * order : 0
             * post_published_at : 1475053200
             * status : 0
             * subtitle :
             * title : 海淘情报局
             * updated_at : 1475136047
             */

            private ColumnBean column;
            private int content_type;
            private String content_url;
            private String cover_image_url;
            private String cover_webp_url;
            private int created_at;
            private int editor_id;
            private int id;
            private String introduction;
            private boolean liked;
            private int likes_count;
            private Object limit_end_at;
            private int published_at;
            private String share_msg;
            private String short_title;
            private int status;
            private String template;
            private String title;
            private String type;
            private int updated_at;
            private String url;
            private List<?> ad_monitors;
            private List<?> feature_list;
            private List<?> label_ids;

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public ColumnBean getColumn() {
                return column;
            }

            public void setColumn(ColumnBean column) {
                this.column = column;
            }

            public int getContent_type() {
                return content_type;
            }

            public void setContent_type(int content_type) {
                this.content_type = content_type;
            }

            public String getContent_url() {
                return content_url;
            }

            public void setContent_url(String content_url) {
                this.content_url = content_url;
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

            public int getEditor_id() {
                return editor_id;
            }

            public void setEditor_id(int editor_id) {
                this.editor_id = editor_id;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public boolean isLiked() {
                return liked;
            }

            public void setLiked(boolean liked) {
                this.liked = liked;
            }

            public int getLikes_count() {
                return likes_count;
            }

            public void setLikes_count(int likes_count) {
                this.likes_count = likes_count;
            }

            public Object getLimit_end_at() {
                return limit_end_at;
            }

            public void setLimit_end_at(Object limit_end_at) {
                this.limit_end_at = limit_end_at;
            }

            public int getPublished_at() {
                return published_at;
            }

            public void setPublished_at(int published_at) {
                this.published_at = published_at;
            }

            public String getShare_msg() {
                return share_msg;
            }

            public void setShare_msg(String share_msg) {
                this.share_msg = share_msg;
            }

            public String getShort_title() {
                return short_title;
            }

            public void setShort_title(String short_title) {
                this.short_title = short_title;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getTemplate() {
                return template;
            }

            public void setTemplate(String template) {
                this.template = template;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
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

            public List<?> getAd_monitors() {
                return ad_monitors;
            }

            public void setAd_monitors(List<?> ad_monitors) {
                this.ad_monitors = ad_monitors;
            }

            public List<?> getFeature_list() {
                return feature_list;
            }

            public void setFeature_list(List<?> feature_list) {
                this.feature_list = feature_list;
            }

            public List<?> getLabel_ids() {
                return label_ids;
            }

            public void setLabel_ids(List<?> label_ids) {
                this.label_ids = label_ids;
            }

            public static class AuthorBean {
                private String avatar_url;
                private Object avatar_webp_url;
                private int created_at;
                private int id;
                private String nickname;

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }

                public Object getAvatar_webp_url() {
                    return avatar_webp_url;
                }

                public void setAvatar_webp_url(Object avatar_webp_url) {
                    this.avatar_webp_url = avatar_webp_url;
                }

                public int getCreated_at() {
                    return created_at;
                }

                public void setCreated_at(int created_at) {
                    this.created_at = created_at;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }
            }

            public static class ColumnBean {
                private String banner_image_url;
                private String category;
                private String cover_image_url;
                private int created_at;
                private String description;
                private int id;
                private int order;
                private int post_published_at;
                private int status;
                private String subtitle;
                private String title;
                private int updated_at;

                public String getBanner_image_url() {
                    return banner_image_url;
                }

                public void setBanner_image_url(String banner_image_url) {
                    this.banner_image_url = banner_image_url;
                }

                public String getCategory() {
                    return category;
                }

                public void setCategory(String category) {
                    this.category = category;
                }

                public String getCover_image_url() {
                    return cover_image_url;
                }

                public void setCover_image_url(String cover_image_url) {
                    this.cover_image_url = cover_image_url;
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

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getOrder() {
                    return order;
                }

                public void setOrder(int order) {
                    this.order = order;
                }

                public int getPost_published_at() {
                    return post_published_at;
                }

                public void setPost_published_at(int post_published_at) {
                    this.post_published_at = post_published_at;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getSubtitle() {
                    return subtitle;
                }

                public void setSubtitle(String subtitle) {
                    this.subtitle = subtitle;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getUpdated_at() {
                    return updated_at;
                }

                public void setUpdated_at(int updated_at) {
                    this.updated_at = updated_at;
                }
            }
        }
    }
}
