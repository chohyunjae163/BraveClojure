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

(defn add2 [n] (inc (inc n)))


(defn str-reverse [s]
  (if (= (count s) 1)
    (first s)
    (str (str-reverse (nthrest s 1)) (first s))))

(def my-name-len (str-reverse "jaycho"))

(println my-name-len)
"jay"
"ay"
"y"
"y"
"ya"
"yaj"


(defn isPalindromicNumber [n]
  (= (str n) (str-reverse (str n))))

(defn smallestPalindromicNumber []
  (loop [number 1]
    (if (isPalindromicNumber number)
      number
      (recur (add2 number)))))


(def is-my-name-palin? (isPalindromicNumber "42524513"))

(println is-my-name-palin?)