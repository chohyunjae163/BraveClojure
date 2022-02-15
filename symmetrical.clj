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

(defn palindromicDecimal? 
  [n]
  (= (str n) (str-reverse (str n))))

(defn palindromicBinary? 
  [n]
  (= (str n) (str-reverse (str n))))

(defn palindromicOctal? 
  [n]
  (= (str n) (str-reverse (str n))))

(defn decimalToBinary
  [n]
  (if (= n 0)
    0
    (mod n 2)))



(println(mod2 7))

(defn smallestPalindromicNumber 
  []
  (loop [number 1]
    (if (and (palindromicDecimal? number)
             (palindromicBinary? number)
             (palindromicOctal? number))
      number
      (recur (add2 number)))))
