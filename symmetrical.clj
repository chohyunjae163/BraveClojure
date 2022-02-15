;; The Quiz 1
;; find the smallest palindromic number (binary, octal, decimal) that is greater than 10.

(defn str-reverse 
  [s]  
  (apply str (reverse s)))

(defn add2 
  [n] 
  (inc (inc n)))

(def mod2 #(mod % 2))
(def mod8 #(mod % 8))
(def quot2 #(quot % 2))
(def quot8 #(quot % 8))

(defn decimalToBinary
  [n]
  (if (< n 2)
    (str n)
    (str (decimalToBinary (quot2 n)) (mod2 n))))

(defn decimalToOctal
  [n]
  (if (< n 8)
    (str n)
    (str (decimalToOctal (quot8 n)) (mod8 n))))

(defn palindromicDecimal? 
  [n]
  (= (str n) (str-reverse (str n))))

(defn palindromicBinary? 
  [n]
  (let [binary (decimalToBinary n)]
    (= binary (str-reverse binary))))

(defn palindromicOctal? 
  [n]
  (let [octal (decimalToOctal n)]
   (= octal (str-reverse octal))))


(def smallestPalindromicNumber 
  (loop [number 11]
    (if (and (palindromicDecimal? number)
             (palindromicBinary? number)
             (palindromicOctal? number))
      number
      (recur (add2 number)))))


(println smallestPalindromicNumber)

;;the answer should be 585