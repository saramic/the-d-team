set -euoxf pipefail

filename="$1"
url="$2"
ogr2ogr -s_srs EPSG:3857 -t_srs EPSG:3857 -f GeoJSON "small_data/postcode_${filename}.json" "${url}" OGRGeoJSON

