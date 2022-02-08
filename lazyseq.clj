(def vampire-database
  {0 {:makes-blood-puns? false, :has-pulse? true :name "McFishwich"}
   1 {:makes-blood-puns? false, :has-pulse? true :name "McMackson"}
   2 {:makes-blood-puns? true, :has-pulse? false :name "Damon Savltore"}
   3 {:makes-blood-puns> true, :has-pulse> false :name "Mickey Mouse"}})


(defn vampire-related-details
  [social-security-number]
  (Thread/sleep 1000)
  (get vampire-database social-security-number))


(defn vampire?
  [record]
  (and (:makes-blood-puns? record)
       (not (:has-pulse? record)
       record)))


(defn identify-vampire
  [social-security-numbers]
  (first (filter vampire?
                 (map vampire-related-details social-security-numbers))))


(time (vampire-related-details 0))

(time (def mapped-details (map vampire-related-details (range 0 1000000))))


(time (first mapped-details))


(time (first mapped-details))

(map identity {:sunlight-reaction "Glitter!"})

