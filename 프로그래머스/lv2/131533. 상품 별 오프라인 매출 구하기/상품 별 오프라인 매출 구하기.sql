-- 코드를 입력하세요
SELECT product_code, sum(PRICE * SALES_AMOUNT) as sales from PRODUCT 
join offline_sale on product.product_id = offline_sale.product_id
group by product_code
order by sales desc, product_code


# SELECT PRODUCT_CODE,SUM(PRICE * SALES_AMOUNT) AS SALES FROM PRODUCT 
# JOIN OFFLINE_SALE ON PRODUCT.PRODUCT_ID = OFFLINE_SALE.PRODUCT_ID
# GROUP BY PRODUCT_CODE
# ORDER BY SALES DESC,PRODUCT_CODE