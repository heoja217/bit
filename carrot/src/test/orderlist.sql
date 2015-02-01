  insert into MATCHING(CNO, SNO, MLEVEL, MDATE) 
  values('2', '1', '3', '2015-01-01');
  
  insert into MATCHING(CNO, SNO, MLEVEL, MDATE) 
  values('2', '2', '2', '2015-01-02');
  
  insert into ORDERLIST(OCODE, SNO, CNO, GNO, ODATE, RDATE, OQTY) 
  values(1, 1, 2, 4,'2015-01-01', '2015-01-01', 10);
  insert into ORDERLIST(OCODE, SNO, CNO, GNO, ODATE, RDATE, OQTY) 
  values(2, 1, 2, 5,'2015-01-01', '2015-01-01', 20);
  insert into ORDERLIST(OCODE, SNO, CNO, GNO, ODATE, RDATE, OQTY) 
  values(3, 1, 2, 7,'2015-01-01', '2015-01-01', 30);
  insert into ORDERLIST(OCODE, SNO, CNO, GNO, ODATE, RDATE, OQTY) 
  values(4, 1, 2, 8,'2015-01-01', '2015-01-01', 40);
  
  insert into ORDERLIST(OCODE, SNO, CNO, GNO, ODATE, RDATE, OQTY) 
  values(5, 2, 2, 4,'2015-01-01', '2015-01-02', 10);
  insert into ORDERLIST(OCODE, SNO, CNO, GNO, ODATE, RDATE, OQTY) 
  values(6, 2, 2, 5,'2015-01-01', '2015-01-02', 20);
  insert into ORDERLIST(OCODE, SNO, CNO, GNO, ODATE, RDATE, OQTY) 
  values(7, 2, 2, 7,'2015-01-01', '2015-01-02', 30);
  insert into ORDERLIST(OCODE, SNO, CNO, GNO, ODATE, RDATE, OQTY) 
  values(8, 2, 2, 8,'2015-01-01', '2015-01-02', 40);
  
  INSERT INTO ORDERTOTAL(CNO,SNO,TOT_MONTH,TOT_PRICE) 
  values(2, 1, '2015-01-31', 400000);
  
  INSERT INTO ORDERTOTAL(CNO,SNO,TOT_MONTH,TOT_PRICE) 
  values(2, 1, '2014-12-31', 200000);
    
  INSERT INTO ORDERTOTAL(CNO,SNO,TOT_MONTH,TOT_PRICE) 
  values(2, 1, '2014-11-30', 300000);
  
    
  INSERT INTO ORDERTOTAL(CNO,SNO,TOT_MONTH,TOT_PRICE) 
  values(2, 2, '2015-01-31', 600000);
  
  INSERT INTO ORDERTOTAL(CNO,SNO,TOT_MONTH,TOT_PRICE) 
  values(2, 2, '2014-12-31', 500000);
    
  INSERT INTO ORDERTOTAL(CNO,SNO,TOT_MONTH,TOT_PRICE) 
  values(2, 2, '2014-11-30', 400000);
    
  
  INSERT INTO ORDERTOTAL(CNO,SNO,TOT_MONTH,TOT_PRICE) 
  values(3, 1, '2015-01-31', 400000);
  
  INSERT INTO ORDERTOTAL(CNO,SNO,TOT_MONTH,TOT_PRICE) 
  values(3, 1, '2014-12-31', 200000);
    
  INSERT INTO ORDERTOTAL(CNO,SNO,TOT_MONTH,TOT_PRICE) 
  values(3, 1, '2014-11-30', 300000);
  
    
  
 	SELECT C.CNO, C.CCNAME, M.MLEVEL,O.DDATE,
		substring(OT.TOT_MONTH,6,2), OT.TOT_PRICE
	FROM CLIENT C, MATCHING M, ORDERLIST O, ORDERTOTAL OT
	WHERE C.CNO=M.CNO AND C.CNO=O.CNO AND O.SNO=M.SNO AND
		O.SNO=M.SNO AND O.CNO=OT.CNO AND O.SNO=OT.SNO AND .SNO=2;
		
	  SELECT 
		  O.OCODE, O.SNO, O.ODATE, O.RDATE, O.OQTY, O.DEL_STAT, O.OMEMO,  
		  C.CNO, C.CCNAME,
		  G.GNO, G.GNAME, G.GUNIT, G.GCAT
		FROM ORDERLIST O LEFT JOIN CLIENT C 
		ON O.CNO=C.CNO LEFT JOIN GOODS G ON O.GNO=G.GNO
		WHERE O.SNO=1 group by O.CNO	
		ORDER BY O.OCODE	
		
 		SELECT C.CNO, C.CCNAME, M.MLEVEL,O.DDATE,
			OT.TOT_PRICE
		FROM CLIENT C LEFT JOIN MATCHING M ON C.CNO=M.CNO
			LEFT JOIN ORDERLIST O ON C.CNO=O.CNO
			LEFT JOIN ORDERTOTAL OT ON C.CNO=OT.CNO
 		WHERE M.SNO=1 AND OT.TOT_MONTH="2014-12-31" group by O.CNO 	
		ORDER BY O.OCODE	
 		
		SELECT C.CNO, C.CCNAME, M.MLEVEL,O.RDATE,O.ODATE,
			OT.TOT_PRICE
		FROM CLIENT C LEFT JOIN MATCHING M ON C.CNO=M.CNO
			LEFT JOIN ORDERLIST O ON C.CNO=O.CNO
			LEFT JOIN ORDERTOTAL OT ON C.CNO=OT.CNO
 		WHERE M.SNO=1 group by O.CNO 	
		ORDER BY O.ODATE	

				SELECT C.CNO, C.CCNAME, M.MLEVEL,O.RDATE,O.ODATE,O.ODATE,OT.TOT_PRICE
		FROM CLIENT C LEFT JOIN MATCHING M ON C.CNO=M.CNO
			LEFT JOIN ORDERLIST O ON C.CNO=O.CNO
			LEFT JOIN ORDERTOTAL OT ON C.CNO=OT.CNO
 		WHERE M.SNO=1 group by O.CNO 	
		ORDER BY O.ODATE	


		SELECT C.CNO, C.CCNAME, M.MLEVEL,
			O.OCODE,O.RDATE,O.ODATE,O.ODATE, O.OQTY,O.DEL_STAT, O.OMEMO, OT.TOT_PRICE,
		  G.GNO, G.GNAME, G.GUNIT, G.GCAT
		FROM CLIENT C LEFT JOIN MATCHING M ON C.CNO=M.CNO
			LEFT JOIN ORDERLIST O ON C.CNO=O.CNO
			LEFT JOIN ORDERTOTAL OT ON C.CNO=OT.CNO
			LEFT JOIN GOODS G ON O.GNO=G.GNO
 		WHERE M.SNO=1 group by O.CNO 	
		ORDER BY O.ODATE	
	
		SELECT GNO, GCAT, GUNIT
    	FROM GOODS
    WHERE SNO=1 group by GCAT
    ORDER BY GCAT ASC
    
    SELECT GNO, GCAT, GUNIT
    	FROM GOODS
    WHERE SNO=1 group by GUNIT
    ORDER BY GUNIT ASC
    
    SELECT GNO, GCAT, GNAME, GUNIT
    	FROM GOODS
    WHERE SNO=1 AND GCAT='대두유'
    ORDER BY GNAME ASC		
    
    
    
	insert into ORDERLIST(SNO, CNO, GNO, ODATE, RDATE, OQTY, OPRICE)
		select 2, 2, 8,'2015-01-01', '2015-01-02', 40, (case M.MLEVEL when '1' then G.GPRICE_A
    when '2' then G.GPRICE_B 
    when '3' then G.GPRICE_C
    end)
    	from GOODS G LEFT JOIN MATCHING M ON G.SNO=G.SNO
		where M.SNO=1
		and M.CNO=2
		and G.GNO=8
		
		
		
  	values(2, 2, 8,'2015-01-01', '2015-01-02', 40);
    
    select case M.MLEVEL when '1' then G.GPRICE_A
    when '2' then G.GPRICE_B 
    when '3' then G.GPRICE_C
    end
    	from GOODS G LEFT JOIN MATCHING M ON G.SNO=G.SNO
		where M.SNO=1
		and M.CNO=2
		and G.GNO=8
		
    
    
    insert into ORDERLIST(SNO,CNO,GCODE,ODATE,ORDATE,OQTY,OPRICE)
			select  1, 1, '87002','2015-01-01', '2015-01-02', 40,(case M.MLEVEL when '1' then G.GPRICE_A
	    when '2' then G.GPRICE_B 
	    when '3' then G.GPRICE_C
	    end)
	    	from GOODS G LEFT JOIN MATCHING M ON G.SNO=G.SNO
			where M.SNO=1
			and M.CNO=1
			and G.GCODE='87002'
    
    