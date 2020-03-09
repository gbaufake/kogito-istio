QUAY_USER ?= gbaufake
QUAY_REPO ?= quay.io/${QUAY_USER}/heavy-delivery

create-native-image:
	mvn package -Pnative -Dquarkus.native.container-build=true&& docker build -f src/main/docker/native/Dockerfile -t ${QUAY_REPO}:v1 .

create-jvm-image:
	mvn package && docker build -f src/main/docker/jvm/Dockerfile -t ${QUAY_REPO}:v1 .

push-image:
	docker push ${QUAY_REPO}


deploy-heavy-delivery:
	# oc new-project kogito-istio
	# oc project kogito-istio
	oc apply -f src/main/openshift/service.yaml -n kogito-istio
	oc apply -f src/main/openshift/deployment.yaml -n kogito-istio
	oc apply -f src/main/openshift/route.yaml -n kogito-istio

deploy-istio-gateway:
	ansible-playbook src/main/kubernetes/ansible/quarkus.yml -e '{"quarkus": {"namespace": "kogito-istio", "control_plane_namespace": "istio-system"}}' -v
