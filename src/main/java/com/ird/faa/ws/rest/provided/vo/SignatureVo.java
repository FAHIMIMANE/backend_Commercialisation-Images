package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class SignatureVo {

    private String id ;
    private String dateSignature ;


            private String dateSignatureMax ;
            private String dateSignatureMin ;

        private ContributeurVo contributeurVo ;
        private ContractVo contractVo ;


    public SignatureVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getDateSignature(){
        return this.dateSignature;
        }

        public void setDateSignature(String dateSignature){
        this.dateSignature = dateSignature;
        }


            public String getDateSignatureMax(){
            return this.dateSignatureMax;
            }

            public String getDateSignatureMin(){
            return this.dateSignatureMin;
            }

            public void setDateSignatureMax(String dateSignatureMax){
            this.dateSignatureMax = dateSignatureMax;
            }

            public void setDateSignatureMin(String dateSignatureMin){
            this.dateSignatureMin = dateSignatureMin;
            }


        public ContributeurVo getContributeurVo(){
        return this.contributeurVo;
        }

        public void setContributeurVo(ContributeurVo contributeurVo){
        this.contributeurVo = contributeurVo;
        }
        public ContractVo getContractVo(){
        return this.contractVo;
        }

        public void setContractVo(ContractVo contractVo){
        this.contractVo = contractVo;
        }


            }
