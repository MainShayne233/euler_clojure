(require '[clojure.string :as s])

(defn products_in_range_for [x a b] (map (fn [n] (* n x)) (range a b)))

(defn products_of_two_three_digit_numbers []
  (flatten
    (map
      (fn [x] (products_in_range_for x 100 999))
     (range 100 999)
    )
  )
)

(defn is_palindrome? [n]
  (= (s/reverse (str n)) (str n) )
)

(defn only_palindromes [list]
  (filter is_palindrome? list)
)

(println
  (apply max
    (only_palindromes (products_of_two_three_digit_numbers))
  )
)
