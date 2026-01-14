/* ■ [回答]と記載のある箇所へ、1〜8の各課題内容に沿ったSQL文を記述しなさい。 */

-- 1. Staffテーブルから「経理部」に所属する社員の情報をすべて抽出してください。
SELECT * from staff WHERE section='経理部';

-- 2. 在庫(Stocksテーブル)の在庫数(Quantity)が10以上25未満のものを抽出して下さい。
SELECT A.total FROM order_header A WHERE A.total  > 5000
INTERSECT
SELECT B.total  FROM order_header B WHERE B.total  < 10000;

-- 3. INTERSECT演算子を使用して、Order_Headerテーブルで合計値(Total)が5000以上10000未満のものを抽出して下さい。
SELECT A.total FROM order_header A WHERE A.total  > 5000
INTERSECT
SELECT B.total  FROM order_header B WHERE B.total  < 10000;

-- 4. 「関東」エリアの全店舗情報（店舗所在地と店舗情報）を抽出して下さい。※テーブル結合すること
SELECT * FROM area JOIN shop ON area.areacode = shop.areacode;

-- 5. 在庫(Stocksテーブル)内の各商品の合計数量を抽出して下さい。
SELECT goodscode, SUM(quantity) FROM stocks
GROUP BY goodscode;

-- 6. 商品（Gods）テーブルから単価（UnitPrice)が5000円より高い商品の情報を全て抽出して下さい。
SELECT * from goods WHERE unitprice>5000;

-- 7. Shopテーブルの全ての店舗コード（Shopcode）、店舗名（Shopname）を、所在地（areaname）とあわせて抽出してください。
SELECT s.shopcode, s.shopname, a.areaname
FROM shop s
JOIN area a
  ON s.areacode = a.areacode;
-- 8. 「新宿」店の在庫数が10以上の商品の商品コード（GoodsCode）、商品名（GoodsName）、在庫数（quantity）を抽出して下さい。
SELECT 
  g.goodscode,
  g.goodsname,
  s.quantity
FROM stocks s
JOIN shop sh
  ON s.shopcode = sh.shopcode
JOIN goods g
  ON s.goodscode = g.goodscode
WHERE sh.shopname = '新宿'
  AND s.quantity >= 10;

