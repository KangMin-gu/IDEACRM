package com.crud.ideacrm.dto;

    public class ProductDto {

        private int prdno;
        private String prdname;
        private int grpno;
        private int grpupper;
        private String grpname;
        private int prdvalue;
        private String prddesc;
        private String erpno;
        private int upperprdno;
        private String regdate;
        private int reguser;
        private String edtdate;
        private int edtuser;
        private int isdelete;
        private int siteid;
        private String prdprice;

        public ProductDto() {}

        public ProductDto(int prdno, String prdname, int grpno, int grpupper, String grpname, int prdvalue, String prddesc, String erpno, int upperprdno, String regdate, int reguser, String edtdate, int edtuser, int isdelete, int siteid, String prdprice) {
            this.prdno = prdno;
            this.prdname = prdname;
            this.grpno = grpno;
            this.grpupper = grpupper;
            this.grpname = grpname;
            this.prdvalue = prdvalue;
            this.prddesc = prddesc;
            this.erpno = erpno;
            this.upperprdno = upperprdno;
            this.regdate = regdate;
            this.reguser = reguser;
            this.edtdate = edtdate;
            this.edtuser = edtuser;
            this.isdelete = isdelete;
            this.siteid = siteid;
            this.prdprice = prdprice;
        }

        public int getPrdno() {
            return prdno;
        }

        public void setPrdno(int prdno) {
            this.prdno = prdno;
        }

        public String getPrdname() {
            return prdname;
        }

        public void setPrdname(String prdname) {
            this.prdname = prdname;
        }

        public int getGrpno() {
            return grpno;
        }

        public void setGrpno(int grpno) {
            this.grpno = grpno;
        }

        public int getGrpupper() {
            return grpupper;
        }

        public void setGrpupper(int grpupper) {
            this.grpupper = grpupper;
        }

        public String getGrpname() {
            return grpname;
        }

        public void setGrpname(String grpname) {
            this.grpname = grpname;
        }

        public int getPrdvalue() {
            return prdvalue;
        }

        public void setPrdvalue(int prdvalue) {
            this.prdvalue = prdvalue;
        }

        public String getPrddesc() {
            return prddesc;
        }

        public void setPrddesc(String prddesc) {
            this.prddesc = prddesc;
        }

        public String getErpno() {
            return erpno;
        }

        public void setErpno(String erpno) {
            this.erpno = erpno;
        }

        public int getUpperprdno() {
            return upperprdno;
        }

        public void setUpperprdno(int upperprdno) {
            this.upperprdno = upperprdno;
        }

        public String getRegdate() {
            return regdate;
        }

        public void setRegdate(String regdate) {
            this.regdate = regdate;
        }

        public int getReguser() {
            return reguser;
        }

        public void setReguser(int reguser) {
            this.reguser = reguser;
        }

        public String getEdtdate() {
            return edtdate;
        }

        public void setEdtdate(String edtdate) {
            this.edtdate = edtdate;
        }

        public int getEdtuser() {
            return edtuser;
        }

        public void setEdtuser(int edtuser) {
            this.edtuser = edtuser;
        }

        public int getIsdelete() {
            return isdelete;
        }

        public void setIsdelete(int isdelete) {
            this.isdelete = isdelete;
        }

        public int getSiteid() {
            return siteid;
        }

        public void setSiteid(int siteid) {
            this.siteid = siteid;
        }

        public String getPrdprice() {
            return prdprice;
        }

        public void setPrdprice(String prdprice) {
            this.prdprice = prdprice;
        }
    }
