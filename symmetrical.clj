;; find the smallest palindromic number (binary, octal, decimal)
;;get N
;;check decimal palindrome
;;(def isDecimalPalindromic)
;;check binary palindrome
;;(def isBinaryPalindromic)
;;check octal palindrome
;;(def isOctalPalindromic)
;;if all checks out, return N
;;else add 2.


(defn my-reverse 
  [s]
  (if (= (count s) 1)
    (first s)
    (str (my-reverse (nthrest s 1)) (first s))))

(defn str-reverse 
  [s]  
  (apply str (reverse s)))

(defn add2 
  [n] 
  (inc (inc n)))

(def mod2 #(mod % 2))
(def mod8 #(mod % 8))

(defn decimalToBinary
  [n]
  (if (< n 2)
    (str n)
    (str (decimalToBinary (quot n 2)) (mod2 n))))

(defn decimalToOctal
  [n]
  (if (< n 8)
    (str n)
    (str (decimalToOctal (quot n 8)) (mod8 n))))

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