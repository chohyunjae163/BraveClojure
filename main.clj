(println(str "hello " "clojure"))
(println(vector  4 6 21))
(println(list 4 "three" {32 72}))
(println(hash-set 4 73 4 96 6 4 6))
(println(hash-map :first "Jay" :last "Cho"))


(defn inc-maker
  "create a custom incrementor"
  [inc-by]
  #(+ % inc-by))


(def inc100 (inc-maker 100))

(println(inc100 4))

(def arr [1 2 3 4 5])

(println(loop [remaining-arr arr final []]
  (if (empty? remaining-arr)
  final
  (let[[fst & remain] remaining-arr]
    (recur remain
      (into final
        (set [(+ fst 4)])))))))


(def human-consumption [8.1 7.3 6.6 5.0])
(def critter-consumption [0.0 0.2 0.3 1.1])
(defn unify-diet-data
  [human critter]
  {:human human
   :critter critter})

(println(map unify-diet-data human-consumption critter-consumption))


(println "done")
