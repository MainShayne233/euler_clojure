(defn sum [list] (reduce (fn [x y] (+ x y) ) list ) )

(defn is_even [x] (= (mod x 2) 0))

(defn only_evens [list] (filter is_even list))

(defn second_last [list]
  (nth list
    (- (count list) 2 )
  )
)

(defn next_fib_number [list]
  (+ (second_last list) (last list))
)

(defn next_fib_sequence [list]
  (into [] (concat list [(next_fib_number list)]))
)

(defn get_fib_sequence_to [limit, sequence]
  (case (< (last sequence) limit)
    true (get_fib_sequence_to limit (next_fib_sequence sequence))
    false (pop sequence)
  )
)

(defn fib_sequence_to [limit]
  (get_fib_sequence_to limit [1 2])
)

(println
  (sum
    (only_evens
      (fib_sequence_to 4000000)
    )
  )
)
