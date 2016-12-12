(ns alphabet-cipher.coder)

(defn stratch-keyword [keyword length]
  (take length (apply concat (repeat keyword)))
  )

(defn char-to-int [number]
  (- (int number) (int \a)))

(defn int-to-char [number]
  (if (and (>=  number (char-to-int \a))
             (<= number (char-to-int \z)))
    (char (+ number (int \a)))
    (char (+ (mod number 26) (int \a)))))

(defn encode [keyword message]
    (->>
      (stratch-keyword keyword (count message))
      (map #(+ (char-to-int %1) (char-to-int %2)) message)
      (map int-to-char)
      (apply str)))

(defn decode [keyword message]
  (->>
    (stratch-keyword keyword (count message))
    (map #(- (char-to-int %1) (char-to-int %2)) message)
    (map int-to-char)
    (apply str))
  )

(defn remove-duplication [in]
  (loop [n 1]
    (if (not-every? true? (map = in (drop n in)))
      (recur (inc n))
      (take n in))))

(defn decipher [cipher message]
  (->>
    (map #(- (char-to-int %1)(char-to-int %2)) cipher message)  
    (map int-to-char)
    remove-duplication
    (apply str))
    )


