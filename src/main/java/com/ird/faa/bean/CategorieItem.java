package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "categorie_item")
public class CategorieItem   {

@Id
    @SequenceGenerator(name="categorie_item_seq",sequenceName="categorie_item_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="categorie_item_seq")
private Long id;


    @ManyToOne
    private Image image ;
    @ManyToOne
    private CategorieImage categorieImage ;


public CategorieItem(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public Image getImage(){
            return this.image;
            }
            public void setImage(Image image){
            this.image = image;
            }
            public CategorieImage getCategorieImage(){
            return this.categorieImage;
            }
            public void setCategorieImage(CategorieImage categorieImage){
            this.categorieImage = categorieImage;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieItem categorieItem = (CategorieItem) o;
        return id != null && id.equals(categorieItem.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

