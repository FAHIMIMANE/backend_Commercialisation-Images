package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "tag_bucket")
public class TagBucket   {

@Id
    @SequenceGenerator(name="tag_bucket_seq",sequenceName="tag_bucket_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="tag_bucket_seq")
private Long id;


    @ManyToOne
    private Bucket bucket ;
    @ManyToOne
    private Tag tag ;


public TagBucket(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public Bucket getBucket(){
            return this.bucket;
            }
            public void setBucket(Bucket bucket){
            this.bucket = bucket;
            }
            public Tag getTag(){
            return this.tag;
            }
            public void setTag(Tag tag){
            this.tag = tag;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagBucket tagBucket = (TagBucket) o;
        return id != null && id.equals(tagBucket.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

