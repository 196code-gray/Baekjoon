-- 코드를 입력하세요
SELECT product_code, sum(PRICE * SALES_AMOUNT) as sales from PRODUCT 
join offline_sale on product.product_id = offline_sale.product_id
group by product_code
order by sales desc, product_code

