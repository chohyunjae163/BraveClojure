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

;;write a filter using reduce
(defn my-filter
  [pred coll]
  (reduce (fn [new-coll val]
            (if (= true (pred val))
              (conj new-coll val)
              new-coll))
            []
            coll))

(def filterEven #(my-filter even? %))

(println (filterEven [71,32,35,4,65,10,20,21,24,34,94]))