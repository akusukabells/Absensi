package com.wendot.absensi.model;

    public class DataMenuModel {

        public String kode_program;
        public String flag;


        // Constructor.

        public DataMenuModel() {
        }

        public DataMenuModel(String kode_program, String flag) {
            this.kode_program = kode_program;
            this.flag = flag;
        }

        public String getKode_program() {
            return kode_program;
        }

        public void setKode_program(String kode_program) {
            this.kode_program = kode_program;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }
    }


