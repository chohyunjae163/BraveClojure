;;Write a function that takes a number and adds 100 to it.
(def add100 #(+ 100 %))
;;Write a function, dec-maker, that works exactly like the function inc-maker except with subtraction:
(defn dec-maker
    [dec-by]
    #(- % dec-by))

;;Write a function, mapset, that works like map except the return value is a set
(defn my-map 
  [f coll] 
  (reduce (fn [new-coll val]
            (conj new-coll (f val)))
          '()
          coll))

(def mapset #(set (my-map %1 %2)))

(println (mapset inc [32 40 55]))