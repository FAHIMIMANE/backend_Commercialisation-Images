package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;
    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class ContributeurVo {

    private String id ;
    private String numeroMatricule ;
    private String emailPrincipale ;
    private String resume ;
    private Boolean credentialsNonExpired ;
    private Boolean enabled ;
    private Boolean accountNonExpired ;
    private Boolean accountNonLocked ;
    private Boolean passwordChanged ;
    private String createdAt ;
    private String updatedAt ;
    private String username ;
    private String password ;
    private String prenom ;
    private String equivalenceAvecPanelErc ;

    public String getBaseHorizon(){
        return this.baseHorizon;
    }



    private String baseHorizon ;
    private String role ;
    private String nom ;
    private String cin ;
    private String numeroTelephone ;
    private String adresse ;
    private String codePostale ;


            private String createdAtMax ;
            private String createdAtMin ;
            private String updatedAtMax ;
            private String updatedAtMin ;


    private List<BucketVo> bucketsVo ;

    public ContributeurVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getNumeroMatricule(){
        return this.numeroMatricule;
        }

        public void setNumeroMatricule(String numeroMatricule){
        this.numeroMatricule = numeroMatricule;
        }
        public String getEmailPrincipale(){
        return this.emailPrincipale;
        }

        public void setEmailPrincipale(String emailPrincipale){
        this.emailPrincipale = emailPrincipale;
        }
        public String getResume(){
        return this.resume;
        }

        public void setResume(String resume){
        this.resume = resume;
        }
        public Boolean getCredentialsNonExpired(){
        return this.credentialsNonExpired;
        }

        public void setCredentialsNonExpired(Boolean credentialsNonExpired){
        this.credentialsNonExpired = credentialsNonExpired;
        }
        public Boolean getEnabled(){
        return this.enabled;
        }

        public void setEnabled(Boolean enabled){
        this.enabled = enabled;
        }
        public Boolean getAccountNonExpired(){
        return this.accountNonExpired;
        }

        public void setAccountNonExpired(Boolean accountNonExpired){
        this.accountNonExpired = accountNonExpired;
        }
        public Boolean getAccountNonLocked(){
        return this.accountNonLocked;
        }

        public void setAccountNonLocked(Boolean accountNonLocked){
        this.accountNonLocked = accountNonLocked;
        }
        public Boolean getPasswordChanged(){
        return this.passwordChanged;
        }

        public void setPasswordChanged(Boolean passwordChanged){
        this.passwordChanged = passwordChanged;
        }
        public String getCreatedAt(){
        return this.createdAt;
        }

        public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
        }
        public String getUpdatedAt(){
        return this.updatedAt;
        }

        public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
        }
        public String getUsername(){
        return this.username;
        }

        public void setUsername(String username){
        this.username = username;
        }
        public String getPassword(){
        return this.password;
        }

        public void setPassword(String password){
        this.password = password;
        }
        public String getPrenom(){
        return this.prenom;
        }

        public void setPrenom(String prenom){
        this.prenom = prenom;
        }
        public String getNom(){
        return this.nom;
        }

        public void setNom(String nom){
        this.nom = nom;
        }
    public String getEquivalenceAvecPanelErc(){
        return this.equivalenceAvecPanelErc;
    }

    public void setEquivalenceAvecPanelErc(String equivalenceAvecPanelErc){
        this.equivalenceAvecPanelErc = equivalenceAvecPanelErc;
    }
    public void setBaseHorizon(String baseHorizon){
        this.baseHorizon = baseHorizon;
    }
    public String getRole(){
        return this.role;
    }

    public void setRole(String role){
        this.role = role;
    }
        public String getCin(){
        return this.cin;
        }

        public void setCin(String cin){
        this.cin = cin;
        }
        public String getNumeroTelephone(){
        return this.numeroTelephone;
        }

        public void setNumeroTelephone(String numeroTelephone){
        this.numeroTelephone = numeroTelephone;
        }
        public String getAdresse(){
        return this.adresse;
        }

        public void setAdresse(String adresse){
        this.adresse = adresse;
        }
        public String getCodePostale(){
        return this.codePostale;
        }

        public void setCodePostale(String codePostale){
        this.codePostale = codePostale;
        }


            public String getCreatedAtMax(){
            return this.createdAtMax;
            }

            public String getCreatedAtMin(){
            return this.createdAtMin;
            }

            public void setCreatedAtMax(String createdAtMax){
            this.createdAtMax = createdAtMax;
            }

            public void setCreatedAtMin(String createdAtMin){
            this.createdAtMin = createdAtMin;
            }

            public String getUpdatedAtMax(){
            return this.updatedAtMax;
            }

            public String getUpdatedAtMin(){
            return this.updatedAtMin;
            }

            public void setUpdatedAtMax(String updatedAtMax){
            this.updatedAtMax = updatedAtMax;
            }

            public void setUpdatedAtMin(String updatedAtMin){
            this.updatedAtMin = updatedAtMin;
            }




        public List<BucketVo> getBucketsVo(){
        return this.bucketsVo;
        }

        public void setBucketsVo(List<BucketVo> bucketsVo){
            this.bucketsVo = bucketsVo;
            }

            }
