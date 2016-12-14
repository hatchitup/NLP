(ns haip.routes.services
  (:require [ring.util.http-response :refer :all]
            [compojure.api.sweet :refer :all]
            [clojure.data.json :as json]
            [schema.core :as s]
            [cheshire.core :refer :all]
            [duckling.core :as p]))

(p/load!) ;; Load default configuration


(s/defschema Thingie {:id Long
                      :hot Boolean
                      :tag (s/enum :kikka :kukka)
                      :chief [{:name String
                               :type #{{:id String}}}]})



(defapi service-routes
  
  (context* "/nlp" []
            :tags ["thingie"]

            (POST* "/time" []
                   :return      String
                   :body-params [text :- String]
                   :summary     "text with body-parameters."
                   ( def n (p/parse :en$core ;; core configuration for English ; see also :fr$core, :es$core, :cn$core
                     text
                     [:time]) )
                    (generate-string n {:pretty true}))

            (POST* "/temperature" []
                   :return      String
                   :body-params [text :- String]
                   :summary     "text with body-parameters."
                   ( def n (p/parse :en$core ;; core configuration for English ; see also :fr$core, :es$core, :cn$core
                     text
                     [:temperature]) )
                    (generate-string n {:pretty true}) )

            (POST* "/number" []
                   :return      String
                   :body-params [text :- String]
                   :summary     "text with body-parameters."
                   ( def n (p/parse :en$core ;; core configuration for English ; see also :fr$core, :es$core, :cn$core
                     text
                     [:number]) )
                    (generate-string n {:pretty true}) )

            (POST* "/ordinal" []
                   :return      String
                   :body-params [text :- String]
                   :summary     "text with body-parameters."
                   ( def n (p/parse :en$core ;; core configuration for English ; see also :fr$core, :es$core, :cn$core
                     text
                     [:ordinal]) )
                    (generate-string n {:pretty true}) )

            (POST* "/distance" []
                   :return      String
                   :body-params [text :- String]
                   :summary     "text with body-parameters."
                   ( def n (p/parse :en$core ;; core configuration for English ; see also :fr$core, :es$core, :cn$core
                     text
                     [:distance]) )
                    (generate-string n {:pretty true}) )

            (POST* "/volume" []
                   :return      String
                   :body-params [text :- String]
                   :summary     "text with body-parameters."
                   ( def n (p/parse :en$core ;; core configuration for English ; see also :fr$core, :es$core, :cn$core
                     text
                     [:volume]) )
                    (generate-string n {:pretty true}) )

            (POST* "/amount-of-money" []
                   :return      String
                   :body-params [text :- String]
                   :summary     "text with body-parameters."
                   ( def n (p/parse :en$core ;; core configuration for English ; see also :fr$core, :es$core, :cn$core
                     text
                     [:amount-of-money]) )
                    (generate-string n {:pretty true}) )

            (POST* "/duration" []
                   :return      String
                   :body-params [text :- String]
                   :summary     "text with body-parameters."
                   ( def n (p/parse :en$core ;; core configuration for English ; see also :fr$core, :es$core, :cn$core
                     text
                     [:duration]) )
                    (generate-string n {:pretty true}) )

            (POST* "/email" []
                   :return      String
                   :body-params [text :- String]
                   :summary     "text with body-parameters."
                   ( def n (p/parse :en$core ;; core configuration for English ; see also :fr$core, :es$core, :cn$core
                     text
                     [:email]) )
                    (generate-string n {:pretty true}) )

          (POST* "/phone-number" []
                 :return      String
                 :body-params [text :- String]
                 :summary     "text with body-parameters."
                 ( def n (p/parse :en$core ;; core configuration for English ; see also :fr$core, :es$core, :cn$core
                   text
                   [:phone-number]) )
                  (generate-string n {:pretty true}) )

            (POST* "/url" []
                   :return      String
                   :body-params [text :- String]
                   :summary     "text with body-parameters."
                   ( def n (p/parse :en$core ;; core configuration for English ; see also :fr$core, :es$core, :cn$core
                     text
                     [:url]) )
                    (generate-string n {:pretty true}) )



            (GET* "/plus" []
                  :return       Long
                  :query-params [x :- Long, {y :- Long 1}]
                  :summary      "x+y with query-parameters. y defaults to 1."
                  (ok (+ x y)))

            (POST* "/minus" []
                   :return      Long
                   :body-params [x :- Long, y :- Long]
                   :summary     "x-y with body-parameters."
                   (ok (- x y)))

            (GET* "/times/:x/:y" []
                  :return      Long
                  :path-params [x :- Long, y :- Long]
                  :summary     "x*y with path-parameters"
                  (ok (* x y)))

            (POST* "/divide" []
                   :return      Double
                   :form-params [x :- Long, y :- Long]
                   :summary     "x/y with form-parameters"
                   (ok (/ x y)))

            (GET* "/power" []
                  :return      Long
                  :header-params [x :- Long, y :- Long]
                  :summary     "x^y with header-parameters"
                  (ok (long (Math/pow x y))))

            (PUT* "/echo" []
                  :return   [{:hot Boolean}]
                  :body     [body [{:hot Boolean}]]
                  :summary  "echoes a vector of anonymous hotties"
                  (ok body))

            (POST* "/echo" []
                   :return   (s/maybe Thingie)
                   :body     [thingie (s/maybe Thingie)]
                   :summary  "echoes a Thingie from json-body"
                   (ok thingie)))

)
