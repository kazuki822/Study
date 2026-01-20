[回答]と記載のある箇所へ、1〜10の各課題内容に沿ったSQL文を記述しなさい。

-- 1. 商品テーブルから価格が20000円以上の商品の商品コードと商品名、価格を取得して下さい。
SELECT goods_code, goods_name, price FROM goods_table
WHERE price ›= 20000;

-- 2. 店舗情報を店舗名のABC順に抽出して下さい。
SELECT * FROM store_table
ORDER BY store_nameAbc ASC;

-- 3. 在庫テーブルに店舗テーブル、商品テーブルを「内部結合」し、店舗名・商品名・在庫数をすべて取得して下さい。
SELECT
store_name, goods_name, quantity
FROM stock_table
INNER JOIN store_table
on stock_table.store_code = store_table.store_code
INNER JOIN
goods_table
on
stock_table-goods_code = goods_table-goods_code;

-- 4. 商品テーブルから全商品の価格の平均値を抽出して下さい。
SELECT AVG(price)
FROM goods_table;

-- 5. 店舗コード（'EA03'）の店舗に関連する在庫情報（商品コード、在庫数、商品名）を取得して下さい。
SELECT
stock_table.goods_code, stock_table.quantity,goods_table.goods_name
FROM
stock_table
INNER
JOIN goods_table
ON
stock_table.goods_code = goods_table. goods_code
WHERE
stock_table.store_code = 'EA03';

-- 6. 商品テーブルに「商品コード='M001'、商品名='マフラー'、価格=4500円、更新日付=本日日付」のデータを追加して下さい。。※実行後の「データ出力」画面も貼付すること。
INSERT INTO goods_table (
    goods_code,
    goods_name,
    price,
    update_day
)
VALUES (
    'M001',
    'マフラー',
    4500,
    CURRENT_DATE
);

-- 7. 店舗テーブルに下記の3つのデータを同時に追加して下さい。
「店舗コード='EA09'、店舗名='新宿店'、店舗名(アルファベット)='SHINJUKUTEN'、更新日='2012-08-01'」
「店舗コード='WE03'、店舗名='梅田店'、店舗名(アルファベット)='UMEDETEN'、更新日='2013-02-01'」
「店舗コード='WE04'、店舗名='福岡店'、店舗名(アルファベット)='FUKUOKATEN'、更新日='2014-05-01'」
INSERT INTO store_table (
store_code, store_name, store_nameAbc, update_day
)
VALUES
('EA09' ,'新宿店','SHINJUKUTEN','2012-08-01'),
('WE03' ,'梅田店','UMEDETEN','2013-02-01' ）,
('WE04' ,'福岡店','FUKUOKATEN','2014-05-01'）,


-- 8. 在庫テーブルの在庫数が20以上の商品の在庫数を50に更新して下さい。※実行後の「データ出力」画面も貼付すること。
UPDATE stock_table
SET quantity= 50
WHERE quantity ›= 20;

-- 9. 在庫テーブルの商品（'S987'）かつ、店舗（'EA01'）の在庫数を10増やす更新を行って下さい。※実行後のSELECT結果も貼付すること。
UPDATE stock_table
SET quantity = quantity + 10
WHERE goods_code = 'S9871' AND goods_code= 'EA01';

-- 10. 商品コード（'Z939'）かつ、店舗コード（'EA04'）に関連する在庫情報を在庫テーブルから削除して下さい。※実行後の「データ出力」画面も貼付すること。
DELETE FROM stock_table
WHERE goods_code = 'Z939' AND store_code = 'EA04';
