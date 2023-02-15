-- 코드를 입력하세요
SELECT book.BOOK_ID, author.AUTHOR_NAME, date_format(book.published_date, '%Y-%m-%d') as PUBLISHED_DATE 
from book
join author on book.author_id = author.author_id
where category like '경제'
order by PUBLISHED_DATE



# DATE_FORMAT(PUBLISHED_DATE,'%Y-%m-%d')