{1  {:pegged true, :connections {6 3, 4 2}},
 2  {:pegged true, :connections {9 5, 7 4}},
 3  {:pegged true, :connections {10 6, 8 5}},
 4  {:pegged true, :connections {13 8, 11 7, 6 5, 1 2}},
 5  {:pegged true, :connections {14 9, 12 8}},
 6  {:pegged true, :connections {15 10, 13 9, 4 5, 1 3}},
 7  {:pegged true, :connections {9 8, 2 4}},
 8  {:pegged true, :connections {10 9, 3 5}},
 9  {:pegged true, :connections {7 8, 2 5}},
 10 {:pegged true, :connections {8 9, 3 6}},
 11 {:pegged true, :connections {13 12, 4 7}},
 12 {:pegged true, :connections {14 13, 5 8}},
 13 {:pegged true, :connections {15 14, 11 12, 6 9, 4 8}},
 14 {:pegged true, :connections {12 13, 5 9}},
 15 {:pegged true, :connections {13 14, 6 10}},
 :rows 5}

 (defn tri*
  "삼각수의 느긋한 배열 만들기"
  ([] (tri* 0 1))
  ([sum n]
    (let [new-sum (+ sum n)]
      (cons new-sum (lazy-seq (tri* new-sum (inc n)))))))

(def tri (tri*))

(println(take-while  tri))

(defn triangular?
  "주어진 숫자가 1, 3, 6, 10, 15 등과 같은 삼각 수인지 판정하기"
  [n]
  (= n (last (take-while #(>= n %) tri))))

(println(triangular? 5))


(println(take-while #(>= 3 %) tri))

(defn row-tri
  "n번째 줄 끝의 삼각수 찾기"
  [n]
  (last(take n tri)))


(defn row-num
  "보드 위치가 속하는 가로 줄 번호 찾기: 예, 위치 1 -> 1번째 가로줄,
   위치 2 및 3 -> 2번째 가로줄 등"
   [pos]
   (inc (count (take-while #(> pos %) tri))))

(println(row-num 12))
(println(inc (count (take-while #(> 5 %) tri))))
(println(take-while #(> 5 %) tri))

(println(take-while #(> 5 %) [ 1 2 6 10]))

(defn connect
  "두 위치 간 서로 연결 맺기"
  [board max-pos pos neighbor destination]
  (if (<= destination max-pos)
    (reduce (fn [new-board [p1 p2]]
              (assoc-in new-board [p1 :connections p2] neighbor))
            board
            [[pos destination] [destination pos]])
    board))

(connect {} 15 1 2 4)