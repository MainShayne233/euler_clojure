(defn sum [list] (reduce (fn [x,y] (+ x y)) list))

(defn divisible_by_3_or_5 [x] (or (= (mod x 3) 0) (= (mod x 5) 0) ) )

(println
  (sum
    (filter divisible_by_3_or_5 (range 1 1000 ) )
  )
)
