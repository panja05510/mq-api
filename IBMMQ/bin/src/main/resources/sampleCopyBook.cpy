   01 EMASSTRT.
     02 CMASNAME       PIC X(0008).
     02 PLEXNAME       PIC X(0008).
     02 CSYSNAME       PIC X(0008).
     02 MON-SPEC       PIC X(0008).
     02 RTA-SPEC       PIC X(0008).
     02 WLM-SPEC       PIC X(0008).
     02 STATUS-R       PIC X(0001).
       88 LOCAL        VALUE X'80'.
       88 REMOTE       VALUE X'40'.
     02 DYNROUTE       PIC X(0001).
       88 ACTIVE       VALUE X'01'.
       88 SUSPEND      VALUE X'02'.
     02 DYNTYPE        PIC X(0003).
       88 WLMTOR       VALUE 'TOR'.
       88 WLMAOR       VALUE 'AOR'.
     02 DESC           PIC X(0030).
     02 CSYSAPPL       PIC X(0008).
     02 EYU-RSV0015    PIC X(0005).
     02 MASSTART       PIC S9(0016) USAGE BINARY.
     02 TMEZONEO       PIC X(0001).
     02 TMEZONE        PIC X(0001).
     02 EYU-RSV0019    PIC X(0002).
     02 DAYLGHTSV      PIC S9(0008) USAGE BINARY.
     02 SYSID          PIC X(0004).
     02 OPSYSREL       PIC X(0004).
     02 MVSNAME        PIC X(0004).
     02 JOBNAME        PIC X(0008).
     02 CECNAME        PIC X(0008).
     02 SYSPLEX        PIC X(0008).
       02 EYU-RSV0257  PIC X(0004).
   01 EMASSTRT-TBL-LEN PIC S9(4) USAGE BINARY VALUE 152.