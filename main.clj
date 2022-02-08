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

(println((comp inc *) 2 3))

(def character
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
                :strength 4
                :dexterity 5}})
(def c-int (comp :intelligence :attributes))
(def c-str (comp :strength :attributes))
(def c-dex (comp :dexterity :attributes))

(println(c-int character))
(println(c-str character))
(println(c-dex character))

(defn sleepy-identity
  "Returns the given value after 1 second"
  [x]
  (Thread/sleep 1000)
  x)

(println(sleepy-identity "Mr.Jay Cho"))
(println(sleepy-identity "Mr.Jay Cho"))

(def memo-sleepy-identity (memoize sleepy-identity))
(println(memo-sleepy-identity "Mr.Jay Cho"))
(println(memo-sleepy-identity "Mr.Jay Cho"))
(println "done")
