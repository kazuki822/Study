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