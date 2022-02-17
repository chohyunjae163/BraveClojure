;;Write a function that takes a number and adds 100 to it.
(def add100 #(+ 100 %))
;;Write a function, dec-maker, that works exactly like the function inc-maker except with subtraction:
(defn dec-maker
    [dec-by]
    #(- % dec-by))

