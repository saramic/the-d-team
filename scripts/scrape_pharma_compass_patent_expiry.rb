#!/usr/bin/env ruby

# to run assuming you have gems installed
# scripts/scrape_pharma_compass_patent_expiry.rb > small_data/pharma_compass_patent_expiry.csv

require "csv"
require "open-uri"
require "nokogiri"

url = 'http://www.pharmacompass.com/patent-expiry-expiration'
doc =  Nokogiri::HTML.parse(open(url))

puts CSV.generate_line(doc.css("table.table th").map(&:text).map(&:strip))

doc.css("table.table tr").each do |row|
  puts CSV.generate_line(row.css("td").map(&:text).map(&:strip)) unless row.css("td").count == 0 
end

